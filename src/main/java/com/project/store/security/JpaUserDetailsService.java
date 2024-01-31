package com.project.store.security;

import java.util.stream.Collectors;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.store.entities.RolEntity;
import com.project.store.entities.UsuarioEntity;
import com.project.store.models.DAO.UsuarioDao;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = usuarioDao.findByEmailUsuario(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("El usuario no existe");

        } 
          return new User(usuario.getEmailUsuario(), usuario.getPasswordUsuario(), mapearAutoridadesRoles(usuario.getRole()));
       
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<RolEntity> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombreRol())).collect(Collectors.toList());

    }

}
