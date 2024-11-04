package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EntregadorService {
    @Autowired
    private EntregadorRepository EntregadorRepository;
    @Transactional
    public Entregador salvar(Entregador Entregador) {
        Entregador.setHabilitado(true);
        Entregador.setVersao(1L);
        //Entregador.setDataCriacao(LocalDate.now());
        return EntregadorRepository.save(Entregador);
    }
    public List<Entregador> listarTodos(){
        return EntregadorRepository.findAll();
    }
    public Entregador obterPorID(Long id){
        return EntregadorRepository.findById(id).orElseThrow();
    }
    @Transactional
    public Entregador update(Long id, Entregador EntregadorAlterado) {
       Entregador Entregador = EntregadorRepository.findById(id).get();
       Entregador.setNome(EntregadorAlterado.getNome());
       Entregador.setDataNascimento(EntregadorAlterado.getDataNascimento());
       Entregador.setCpf(EntregadorAlterado.getCpf());
       Entregador.setFoneCelular(EntregadorAlterado.getFoneCelular());
       Entregador.setFoneFixo(EntregadorAlterado.getFoneFixo());
       Entregador.setEmpresa(EntregadorAlterado.getEmpresa());
       Entregador.setRg(EntregadorAlterado.getRg());
       Entregador.setQtdEntregasRealizadas(EntregadorAlterado.getQtdEntregasRealizadas());
       Entregador.setValorFrete(EntregadorAlterado.getValorFrete());
       Entregador.setEnderecoRua(EntregadorAlterado.getEnderecoRua());
       Entregador.setEnderecoNumero(EntregadorAlterado.getEnderecoNumero());
       Entregador.setEnderecoBairro(EntregadorAlterado.getEnderecoBairro());
       Entregador.setEnderecoCidade(EntregadorAlterado.getEnderecoCidade());
       Entregador.setEnderecoCep(EntregadorAlterado.getEnderecoCep());
       Entregador.setEnderecoUf(EntregadorAlterado.getEnderecoUf());
       Entregador.setComplemento(EntregadorAlterado.getComplemento());
       Entregador.setAtivo(EntregadorAlterado.getAtivo());
       return EntregadorRepository.save(Entregador);
   }
}

