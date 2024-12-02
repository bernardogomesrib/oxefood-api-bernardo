package br.com.ifpe.oxefood.api.cliente.endereco;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.oxefood.modelo.cliente.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoRequest {
    @NotNull(message = "O cliente é obrigatório")
    private Long clienteId;
    @NotBlank(message = "A rua é obrigatória")
    @Length(min = 3, max = 100, message = "A rua deve ter entre 3 e 100 caracteres")
    private String rua;
    @NotBlank(message = "O número é obrigatório")
    @Length(min = 1, max = 10, message = "O número deve ter entre 1 e 10 caracteres")
    private String numero;
    @NotBlank(message = "O bairro é obrigatório")
    @Length(min = 3, max = 100, message = "O bairro deve ter entre 3 e 100 caracteres")
    private String bairro;
    @NotBlank(message = "O CEP é obrigatório")
    @Length(min = 8, max = 8, message = "O CEP deve ter 8 caracteres")
    private String cep;
    @NotBlank(message = "A cidade é obrigatória")
    @Length(min = 3, max = 100, message = "A cidade deve ter entre 3 e 100 caracteres")
    private String cidade;
    @NotBlank(message = "O estado é obrigatório")
    @Length(min = 2, max = 2, message = "O estado deve ter 2 caracteres")
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
