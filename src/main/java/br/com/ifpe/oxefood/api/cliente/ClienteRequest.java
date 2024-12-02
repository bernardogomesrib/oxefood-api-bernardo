package br.com.ifpe.oxefood.api.cliente;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {
    @NotNull(message = "O nome é obrigatório")
    @NotEmpty(message = "O nome não pode ser vazio")
    @Length(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;
    @NotNull(message = "A data de nascimento é obrigatória")
    
    @Past(message = "A data de nascimento deve ser no passado")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    
    @NotBlank(message = "O CPF é obrigatório")
    @CPF(message = "O CPF é inválido")
    private String cpf;
    
    @NotBlank(message = "O telefone celular é obrigatório")
    @Length(min = 11, max = 20, message = "O telefone celular deve ter entre {min} e {max} caracteres")
    private String foneCelular;

    private String foneFixo;

    public Cliente build() {

        return Cliente.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .cpf(cpf)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .build();
    }

}
