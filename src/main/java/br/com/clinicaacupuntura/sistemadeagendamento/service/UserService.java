package br.com.clinicaacupuntura.sistemadeagendamento.service;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.UserModel;
import br.com.clinicaacupuntura.sistemadeagendamento.exceptions.UserNotFoundException;
import br.com.clinicaacupuntura.sistemadeagendamento.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void register(UserModel userModel) {
        userModel.setRole("USER");
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(userModel);
    }

    public UserModel findByLogin(String login) {
        return userRepository.findByUsername(login).orElse(null);
    }
}