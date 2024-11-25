package br.com.ifpe.oxefood.modelo.cliente.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.var;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Transactional
    public Endereco update(Endereco endereco, Long id) {
        var e = enderecoRepository.findById(id);
        if (e.isPresent()) {
            Endereco end = e.get();
            end.setBairro(endereco.getBairro());
            end.setCep(endereco.getCep());
            end.setCidade(endereco.getCidade());
            end.setCliente(endereco.getCliente());
            end.setComplemento(endereco.getComplemento());
            end.setNumero(endereco.getNumero());
            end.setRua(endereco.getRua());
            return enderecoRepository.save(end);
        } else
            return null;
    }

    @Transactional
    public boolean delete(Long id) {
        var end = enderecoRepository.findById(id);
        if (end.isPresent()) {
            enderecoRepository.delete(end.get());
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public Endereco find(Long id) {
        return enderecoRepository.findById(id).get();
    }
}
