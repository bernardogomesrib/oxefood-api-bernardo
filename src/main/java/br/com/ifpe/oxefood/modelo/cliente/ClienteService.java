package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Transactional
    public Cliente salvar(Cliente cliente) {
        cliente.setHabilitado(true);
        cliente.setVersao(1L);
        //cliente.setDataCriacao(LocalDate.now());
        return clienteRepository.save(cliente);
    }
    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }
    public Cliente obterPorID(Long id){
        return clienteRepository.findById(id).orElseThrow();
    }
}
