package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.empresa.Empresa;
import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    private Empresa empresa;
    private String categoria;
    private String codigo;
    private String titulo;
    private String descricao;
    private Double valorUnitario;
    private Integer tempoEntregaMinimo;
    private Integer tempoEntregaMaximo;

   public Produto build() {

       return Produto.builder()
       .empresa(empresa)
       .categoria(categoria)
       .codigo(codigo)
       .titulo(titulo)
       .descricao(descricao)
       .valorUnitario(valorUnitario)
       .tempoEntregaMinimo(tempoEntregaMinimo)
       .tempoEntregaMaximo(tempoEntregaMaximo)
           .build();
   }

}
