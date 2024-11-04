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
}

