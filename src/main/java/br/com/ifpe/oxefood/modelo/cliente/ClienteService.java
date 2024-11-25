package br.com.ifpe.oxefood.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.cliente.endereco.Endereco;
import br.com.ifpe.oxefood.modelo.cliente.endereco.EnderecoRepository;
import jakarta.transaction.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
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
   @Transactional
   public void delete(Long id) {
       Cliente cliente = clienteRepository.findById(id).get();
       cliente.setHabilitado(false);
       clienteRepository.save(cliente);
   }
    @Transactional
   public Endereco adicionarEndereco(Long clienteId, Endereco endereco) {

       Cliente cliente = this.obterPorID(clienteId);
      
       //Primeiro salva o Endereco:

       endereco.setCliente(cliente);
       endereco.setHabilitado(Boolean.TRUE);
       enderecoRepository.save(endereco);
      
       //Depois acrescenta o endereço criado ao cliente e atualiza o cliente:

       List<Endereco> listaEndereco = cliente.getEnderecos();
      
       if (listaEndereco == null) {
           listaEndereco = new ArrayList<Endereco>();
       }
      
       listaEndereco.add(endereco);
       cliente.setEnderecos(listaEndereco);
       clienteRepository.save(cliente);
      
       return endereco;
   }
   @Transactional
   public Endereco atualizarEndereco(Long id, Endereco enderecoAlterado) {

       Endereco endereco = enderecoRepository.findById(id).get();
       endereco.setRua(enderecoAlterado.getRua());
       endereco.setNumero(enderecoAlterado.getNumero());
       endereco.setBairro(enderecoAlterado.getBairro());
       endereco.setCep(enderecoAlterado.getCep());
       endereco.setCidade(enderecoAlterado.getCidade());
       endereco.setEstado(enderecoAlterado.getEstado());
       endereco.setComplemento(enderecoAlterado.getComplemento());

       return enderecoRepository.save(endereco);
   }
   @Transactional
   public void removerEndereco(Long idEndereco) {

       Endereco endereco = enderecoRepository.findById(idEndereco).get();
       endereco.setHabilitado(Boolean.FALSE);
       enderecoRepository.save(endereco);

       Cliente cliente = this.obterPorID(endereco.getCliente().getId());
       cliente.getEnderecos().remove(endereco);
       clienteRepository.save(cliente);
   }

}
