# Etapa de construcción de Tailwind CSS
FROM node:14 AS build-tailwind

WORKDIR /store

# Copia solo los archivos necesarios para instalar las dependencias
COPY /package.json /package-lock.json ./

# Instala las dependencias de Node.js
RUN npm install

# Copia los archivos de Tailwind CSS y compila los estilos
COPY src/main/resources/static/ .
RUN npx tailwindcss build -i ./input.css -o ./output.css

# Etapa de construcción de la aplicación Java
FROM maven:3.8.4-openjdk-17 AS build-java

# Argumento para decidir si eliminar imágenes antiguas
ARG DELETE_OLD_IMAGES=true

# Elimina las imágenes antiguas si DELETE_OLD_IMAGES=true
RUN if [ "$DELETE_OLD_IMAGES" = "true" ]; then \
    docker rmi $(docker images -q) || true; \
fi

# Establece un directorio de trabajo
WORKDIR /store

# Copia solo el archivo POM y los archivos de configuración de Maven
COPY pom.xml .

# Crea el directorio src y copia solo el archivo application.properties
RUN mkdir -p src/main/resources
COPY src/main/resources/application.properties src/main/resources/

# Copia el resto de los archivos del proyecto
COPY src src

# Compila y empaqueta el proyecto
RUN mvn clean package -DskipTests

# Etapa de producción: Utiliza una imagen base de OpenJDK 17 para ejecutar la aplicación
FROM openjdk:17-slim-bullseye

# Establece el directorio de trabajo
WORKDIR /store

# Copia el archivo JAR construido desde la etapa de construcción de Java
COPY --from=build-java /store-0.0.2.jar store.jar

# Copia los archivos de Tailwind CSS desde la etapa de construcción de Tailwind CSS
COPY --from=build-tailwind /store/output.css src/main/resources/static/

# Expone el puerto que utilizará la aplicación
EXPOSE 8080

# Establece las opciones de JVM para la aplicación (ajusta según sea necesario)
ENV JAVA_OPTS=""

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["sh", "-c"]
CMD ["exec java $JAVA_OPTS -XshowSettings:vm \
                -Dinstrument=false \
                -Dspring.profiles.active=$PROFILE \
                -jar store.jar"]
