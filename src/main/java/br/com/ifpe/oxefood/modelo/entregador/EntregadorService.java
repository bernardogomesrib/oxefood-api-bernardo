package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;

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
        Entregador.setDataCriacao(LocalDate.now());
        return EntregadorRepository.save(Entregador);
    }
}
