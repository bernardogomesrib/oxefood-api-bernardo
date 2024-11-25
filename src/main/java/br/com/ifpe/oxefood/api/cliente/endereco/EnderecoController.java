package br.com.ifpe.oxefood.api.cliente.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import br.com.ifpe.oxefood.modelo.cliente.endereco.Endereco;
import br.com.ifpe.oxefood.modelo.cliente.endereco.EnderecoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente/endereco")
@CrossOrigin
public class EnderecoController {
    @Autowired
    EnderecoService enderecoService;
    @Autowired
    ClienteService clienteService;

    @PostMapping("/endereco/{clienteId}")
    public ResponseEntity<Endereco> adicionarEndereco(@PathVariable("clienteId") Long clienteId,
            @RequestBody @Valid EnderecoRequest request) {

        Endereco endereco = clienteService.adicionarEndereco(clienteId, request.build());
        return new ResponseEntity<Endereco>(endereco, HttpStatus.CREATED);
    }

    @PutMapping("/endereco/{enderecoId}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable("enderecoId") Long enderecoId,
            @RequestBody EnderecoRequest request) {

        Endereco endereco = clienteService.atualizarEndereco(enderecoId, request.build());
        return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
    }

    @DeleteMapping("/endereco/{enderecoId}")
    public ResponseEntity<Void> removerEndereco(@PathVariable("enderecoId") Long enderecoId) {

        clienteService.removerEndereco(enderecoId);
        return ResponseEntity.noContent().build();
    }

    
}
