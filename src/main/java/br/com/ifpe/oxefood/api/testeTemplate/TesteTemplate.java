package br.com.ifpe.oxefood.api.testeTemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/teste")
public class TesteTemplate {
    
    @GetMapping
    public String teste() {
        
        return "bem_vindo_cliente";
    }
}
