package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeOrCpf(String nome, String cpf);
}
