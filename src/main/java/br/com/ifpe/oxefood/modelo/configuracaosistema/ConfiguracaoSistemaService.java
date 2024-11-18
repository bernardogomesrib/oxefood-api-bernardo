package br.com.ifpe.oxefood.modelo.configuracaosistema;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ConfiguracaoSistemaService {
    @Autowired
    private ConfiguracaoSistemaRepository configuracaoSistemaRepository;

    @Transactional
    public ConfiguracaoSistema salvar(ConfiguracaoSistema configuracaoSistema) {
        configuracaoSistema.setHabilitado(true);
        return configuracaoSistemaRepository.save(configuracaoSistema);
    }

    public List<ConfiguracaoSistema> listarTodos() {
        return configuracaoSistemaRepository.findAll();
    }

    public ConfiguracaoSistema obterPorID(Long id) {
        return configuracaoSistemaRepository.findById(id).orElseThrow();
    }

    @Transactional
    public ConfiguracaoSistema update(Long id, ConfiguracaoSistema configuracaoSistemaAlterado) {
        ConfiguracaoSistema configuracaoSistema = configuracaoSistemaRepository.findById(id).get();
        configuracaoSistema.setCnpj(configuracaoSistemaAlterado.getCnpj());
        configuracaoSistema.setNomeEmpresa(configuracaoSistemaAlterado.getNomeEmpresa());
        configuracaoSistema.setSite(configuracaoSistemaAlterado.getSite());
        configuracaoSistema.setEmailContato(configuracaoSistemaAlterado.getEmailContato());
        configuracaoSistema.setTempoMinimoAgendamentoPedidos(configuracaoSistemaAlterado.getTempoMinimoAgendamentoPedidos());
        configuracaoSistema.setLigarAceitePedidos(configuracaoSistemaAlterado.isLigarAceitePedidos());
        configuracaoSistema.setDataEntradaSistema(configuracaoSistemaAlterado.getDataEntradaSistema());
        return configuracaoSistemaRepository.save(configuracaoSistema);
    }

    @Transactional
    public void delete(Long id) {
        ConfiguracaoSistema configuracaoSistema = configuracaoSistemaRepository.findById(id).get();
        configuracaoSistema.setHabilitado(false);
        configuracaoSistemaRepository.save(configuracaoSistema);
    }
}
