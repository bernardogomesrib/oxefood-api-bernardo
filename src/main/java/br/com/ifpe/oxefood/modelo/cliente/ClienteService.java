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
    @Transactional
    public void update(Long id, Cliente clienteAlterado) {
 
       Cliente cliente = clienteRepository.findById(id).get();
       cliente.setNome(clienteAlterado.getNome());
       cliente.setDataNascimento(clienteAlterado.getDataNascimento());
       cliente.setCpf(clienteAlterado.getCpf());
       cliente.setFoneCelular(clienteAlterado.getFoneCelular());
       cliente.setFoneFixo(clienteAlterado.getFoneFixo());

       cliente.setVersao(cliente.getVersao() + 1);
       clienteRepository.save(cliente);
   }
 
}
