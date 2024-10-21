package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import br.com.ifpe.oxefood.modelo.empresa.Empresa;
import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

    private Empresa empresa;
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;
    private String foneCelular;
    private String foneFixo;
    private Integer qtdEntregasRealizadas;
    private Double valorFrete;
    private Boolean ativo;

   public Entregador build() {

       return Entregador.builder()
       .empresa(empresa)
       .nome(nome)
       .cpf(cpf)
       .rg(rg)
       .dataNascimento(dataNascimento)
       .foneCelular(foneCelular)
       .foneFixo(foneFixo)
       .qtdEntregasRealizadas(qtdEntregasRealizadas)
       .valorFrete(valorFrete)
       .ativo(ativo)
           .build();
   }

}
