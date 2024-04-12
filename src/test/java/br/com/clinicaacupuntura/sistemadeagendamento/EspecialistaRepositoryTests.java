package br.com.clinicaacupuntura.sistemadeagendamento;

import br.com.clinicaacupuntura.sistemadeagendamento.entities.Endereco;
import br.com.clinicaacupuntura.sistemadeagendamento.entities.Especialista;
import br.com.clinicaacupuntura.sistemadeagendamento.repositories.EspecialistaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class EspecialistaRepositoryTests {
    @Autowired private EspecialistaRepository repo;

    @Test
    public void testAddNew(){
        Especialista especialista = new Especialista();
        Endereco endereco = new Endereco();
        endereco.setRua("Avenida Paulista");
        endereco.setNumero(1500);
        endereco.setCep("22222-222");
        endereco.setEstado("São Paulo");
        endereco.setCidade("São Paulo");

        especialista.setNome("José");
        especialista.setCelular("33333-3333");
        especialista.setEmail("joao@gmail.com");
        especialista.setDataDeNascimento(1988,07,21);
        especialista.setEspecialidade("Acupunturista");
        especialista.setCrm(12345);
        especialista.setEndereco(endereco);
        especialista.setTelefone("3333-3333");

        Especialista savedEspecialista = repo.save(especialista);

        Assertions.assertThat(savedEspecialista).isNotNull();
        Assertions.assertThat(savedEspecialista.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<Especialista> especialistas = repo.findAll();
        Assertions.assertThat(especialistas).hasSizeGreaterThan(0);

        for (Especialista especialista : especialistas){
            System.out.println(especialista);
        }
    }

    @Test
    public void testUpdate(){
        Long userId = 1L;
        Optional<Especialista> optionalEspecialista = repo.findById(userId);
        Especialista especialista = optionalEspecialista.get();
        especialista.setNome("Zezin");
        repo.save(especialista);

        Especialista updatedEspecialista = repo.findById(userId).get();
        Assertions.assertThat(updatedEspecialista.getNome()).isEqualTo("Zezin");
    }
}
