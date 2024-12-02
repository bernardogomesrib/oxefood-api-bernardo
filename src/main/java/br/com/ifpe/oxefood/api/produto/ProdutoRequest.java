package br.com.ifpe.oxefood.api.produto;

import org.hibernate.validator.constraints.Length;

/* import br.com.ifpe.oxefood.modelo.empresa.Empresa; */
import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    /* private Empresa empresa; */
    @NotNull(message = "A categoria é obrigatória")
    private Long categoriaId;
    @NotBlank(message = "O código é obrigatório")
    @Length(min = 3, max = 100, message = "O código deve ter entre 3 e 100 caracteres")
    private String codigo;
    @NotBlank(message = "O título é obrigatório")
    @Length(min = 3, max = 100, message = "O título deve ter entre 3 e 100 caracteres")
    private String titulo;
    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
    @NotNull(message = "O valor unitário é obrigatório")
    private Double valorUnitario;
    @NotNull(message = "O tempo de entrega mínimo é obrigatório")
    private Integer tempoEntregaMinimo;
    @NotNull(message = "O tempo de entrega máximo é obrigatório")
    private Integer tempoEntregaMaximo;

    public Produto build() {
        return Produto.builder()
                .codigo(codigo)
                .titulo(titulo)
                .descricao(descricao)
                .valorUnitario(valorUnitario)
                .tempoEntregaMinimo(tempoEntregaMinimo)
                .tempoEntregaMaximo(tempoEntregaMaximo)
                .build();
    }

}
