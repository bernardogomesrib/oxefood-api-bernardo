package br.com.ifpe.oxefood.api.ConfiguracaoSistema;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.configuracaosistema.ConfiguracaoSistema;
import br.com.ifpe.oxefood.modelo.configuracaosistema.ConfiguracaoSistemaService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/configuracao-sistema")
@CrossOrigin
public class ConfiguracaoSistemaController {
    @Autowired
    private ConfiguracaoSistemaService configuracaoSistemaService;

    @PostMapping
    public ResponseEntity<ConfiguracaoSistema> save(@RequestBody @Valid ConfiguracaoSistemaRequest request) {

        ConfiguracaoSistema ConfiguracaoSistema = configuracaoSistemaService.salvar(request.build());
        return new ResponseEntity<ConfiguracaoSistema>(ConfiguracaoSistema, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ConfiguracaoSistema> listarTodos() {
        return configuracaoSistemaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ConfiguracaoSistema obterPorID(@PathVariable Long id) {
        return configuracaoSistemaService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConfiguracaoSistema> update(@PathVariable("id") Long id, @RequestBody @Valid ConfiguracaoSistemaRequest request) {

        configuracaoSistemaService.update(id, request.build());
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ConfiguracaoSistema> delete(@PathVariable("id") Long id) {
        configuracaoSistemaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
