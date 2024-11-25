package br.com.ifpe.oxefood.api.cliente.endereco;

import br.com.ifpe.oxefood.modelo.cliente.endereco.Endereco;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoRequest {
    private Long clienteId;
    private String rua;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String complemento;

    public Endereco build(){
        return Endereco.builder()
        .rua(rua)
        .numero(numero)
        .bairro(bairro)
        .cep(cep)
        .cidade(cidade)
        .estado(estado)
        .complemento(complemento)
        .build();
    }
}
