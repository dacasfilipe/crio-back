package com.crio.api.repositories;

import com.crio.api.domain.endereco.Endereco;
import com.crio.api.domain.endereco.EnderecoResponseDTO;
import com.crio.api.repositorie.EnderecoRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
public class EnderecoRepositoryTests {

    @Autowired
    EntityManager entityManager;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Test
    @DisplayName("Should get Endereco successfully from DB")
    void findEnderecoByNameDocumentCase1() {
        String city = "Criciúma"; // nome da categoria que estamos procurando
        String uf = "SC";
        EnderecoResponseDTO data = new EnderecoResponseDTO(null, city, uf); // ID nulo para permitir a geração automática
        this.createEndereco(data);//

        Optional<Endereco> result = this.enderecoRepository.findByCity(city);

        assertThat(result.isPresent()).isTrue();
        //assertThat(result.get().getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("Should not get Endereco from DB when Endereco not exists")
    void findEnderecoByNameDocumentCase2() {
        String name = "CategoriaInexistente"; // nome da categoria que estamos procurando

        Optional<Endereco> result = this.enderecoRepository.findByName(name);
        //tentei isso
        //tentei aquilo
        //tentei outra coisa
        assertThat(result.isEmpty()).isTrue();
    }

    private Endereco createEndereco(EnderecoResponseDTO data) {
        Endereco endereco = new Endereco(data);
        this.entityManager.persist(endereco);
        return endereco;
    }
}
