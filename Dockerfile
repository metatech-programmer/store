# Etapa de construcción de Tailwind CSS
FROM node:14 AS build-tailwind

WORKDIR /store

# Copia solo los archivos necesarios para instalar las dependencias
COPY /package.json /package-lock.json ./

# Instala las dependencias de Node.js
RUN npm install

# Copia los archivos de Tailwind CSS y compila los estilos
COPY src/main/resources/static/css/ .
RUN npx tailwindcss build -i ./input.css -o ./output.css

# Etapa de construcción de la aplicación Java
FROM maven:3.8.4-openjdk-17 AS build-java

# ... (resto de la construcción de Java)

# Etapa de producción
FROM openjdk:17-slim-bullseye

WORKDIR /store

# Copia el archivo JAR construido desde la etapa de construcción de Java
COPY --from=build-java /store/target/store-0.0.1.jar store.jar

# Copia los archivos de Tailwind CSS desde la etapa de construcción de Tailwind CSS
COPY --from=build-tailwind /store/output.css src/main/resources/static/css/

# Expone el puerto que utilizará la aplicación
EXPOSE 8080

# Establece las opciones de JVM para la aplicación (ajusta según sea necesario)
ENV JAVA_OPTS=""

# Comando para ejecutar la aplicación Spring Boot
CMD ["java", "$JAVA_OPTS", "-XshowSettings:vm", "-Dinstrument=false", "-Dspring.profiles.active=$PROFILE", "-jar", "store.jar"]
