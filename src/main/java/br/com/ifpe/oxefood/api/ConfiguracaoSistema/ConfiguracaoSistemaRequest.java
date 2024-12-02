package br.com.ifpe.oxefood.api.ConfiguracaoSistema;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.configuracaosistema.ConfiguracaoSistema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguracaoSistemaRequest {
    @NotBlank(message = "O nome da empresa é obrigatório")
    @Length(min = 3, max = 100, message = "O nome da empresa deve ter entre 3 e 100 caracteres")
    private String nomeEmpresa;
    @NotBlank(message = "O CNPJ é obrigatório")
    @CNPJ(message = "O CNPJ é inválido")
    private String cnpj;
    @NotBlank(message = "O site é obrigatório")
    @Length(min = 3, max = 100, message = "O site deve ter entre 3 e 100 caracteres")
    @URL(message = "O site é inválido")
    private String site;
    @NotBlank(message = "O email de contato é obrigatório")
    @Email
    private String emailContato;
    @NotBlank(message = "O tempo mínimo de agendamento de pedidos é obrigatório")
    private Long tempoMinimoAgendamentoPedidos;
    @NotBlank(message = "O aceite de pedidos é obrigatório")
    private boolean ligarAceitePedidos;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message = "A data de entrada no sistema é obrigatória")
    @Past(message = "A data de entrada no sistema deve ser no passado ou Hoje")
    private LocalDate dataEntradaSistema;

    public ConfiguracaoSistema build() {
        return ConfiguracaoSistema.builder()
            .nomeEmpresa(nomeEmpresa)
            .cnpj(cnpj)
            .site(site)
            .emailContato(emailContato)
            .tempoMinimoAgendamentoPedidos(tempoMinimoAgendamentoPedidos)
            .ligarAceitePedidos(ligarAceitePedidos)
            .dataEntradaSistema(dataEntradaSistema)
            .build();
    }
}
