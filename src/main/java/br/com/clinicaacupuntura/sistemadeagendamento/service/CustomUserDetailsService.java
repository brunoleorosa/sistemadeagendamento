package br.com.clinicaacupuntura.sistemadeagendamento.service;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.UserModel;
import br.com.clinicaacupuntura.sistemadeagendamento.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel byLogin = userService.findByLogin(username);
        if (byLogin == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return User.builder()
                .username(byLogin.getUsername())
                .password(byLogin.getPassword())
                .roles(byLogin.getRole())
                .build();
    }
}
