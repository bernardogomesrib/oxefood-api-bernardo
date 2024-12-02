package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

/* import br.com.ifpe.oxefood.modelo.empresa.Empresa; */
import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

    /* private Empresa empresa; */
    @NotBlank(message = "O nome é obrigatório")
    @Length(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;
    @NotBlank(message = "O CPF é obrigatório")
    @CPF(message = "O CPF é inválido")
    private String cpf;
    @NotBlank(message = "O RG é obrigatório")
    @Length(min = 9, max = 14, message = "O RG deve ter entre 9 e 14 caracteres")
    private String rg;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @NotBlank(message = "A data de nascimento é obrigatória")
    private LocalDate dataNascimento;
    @NotBlank(message = "é necessário pelo menos um modo de comunicação")
    @Length(min = 11, max = 20, message = "O telefone celular deve ter entre {min} e {max} caracteres")
    private String foneCelular;
    private String foneFixo;
    @NotBlank(message = "A quantidade de entregas realizadas é obrigatória")
    private Integer qtdEntregasRealizadas;
    @NotBlank(message = "O valor do frete é obrigatório")
    private Double valorFrete;
    @NotBlank(message = "O endereço da rua é obrigatório")
    private String enderecoRua;
    @NotBlank(message = "O número do endereço é obrigatório")
    private String enderecoNumero;
    @NotBlank(message = "O bairro do endereço é obrigatório")
    private String enderecoBairro;
    @NotBlank(message = "A cidade do endereço é obrigatória")
    private String enderecoCidade;
    @NotBlank(message = "O CEP do endereço é obrigatório")
    private String enderecoCep;
    @NotBlank(message = "O estado do endereço é obrigatório")
    private String enderecoUf;
    private String complemento;
    @NotBlank(message = "O status do entregador é obrigatório")
    private Boolean ativo;

    public Entregador build() {

        return Entregador.builder()
                /* .empresa(empresa) */
                .nome(nome)
                .cpf(cpf)
                .rg(rg)
                .dataNascimento(dataNascimento)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .qtdEntregasRealizadas(qtdEntregasRealizadas)
                .valorFrete(valorFrete)
                .ativo(ativo)
                .complemento(complemento)
                .enderecoBairro(enderecoBairro)
                .enderecoCep(enderecoCep)
                .enderecoCidade(enderecoCidade)
                .enderecoNumero(enderecoNumero)
                .enderecoRua(enderecoRua)
                .enderecoUf(enderecoUf)
                .build();
    }

}
