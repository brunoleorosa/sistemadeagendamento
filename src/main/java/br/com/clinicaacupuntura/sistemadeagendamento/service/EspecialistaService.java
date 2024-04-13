package br.com.clinicaacupuntura.sistemadeagendamento.service;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Especialista;
import br.com.clinicaacupuntura.sistemadeagendamento.exceptions.EspecialistaNotFoundException;
import br.com.clinicaacupuntura.sistemadeagendamento.repositories.EspecialistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialistaService {

    @Autowired
    private EspecialistaRepository repo;

    public List<Especialista> listAll() {
        return (List<Especialista>) repo.findAll();
    }

    public void save(Especialista especialista) {
        repo.save(especialista);
    }

    public Especialista get(Long id) throws EspecialistaNotFoundException {
        Optional<Especialista> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new EspecialistaNotFoundException("Não foi possível encontrar um especialista com o ID: " + id + " informado.");
    }

    public void delete(Long id) throws EspecialistaNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0){
            throw new EspecialistaNotFoundException("Não foi possível encontrar um especialista com o ID: " + id + " informado.");
        }
        repo.deleteById(id);
    }
}