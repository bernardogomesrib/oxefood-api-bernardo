package br.com.ifpe.oxefood.api.empresa;

import br.com.ifpe.oxefood.modelo.empresa.Empresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRequest {

    private String site;
    private String cnpj;
    private String inscricaoEstadual;
    private String nomeEmpresarial;
    private String nomeFantasia;
    private String fone;
    private String foneAlternativo;

   public Empresa build() {

       return Empresa.builder()
       .site(site)
       .cnpj(cnpj)
       .inscricaoEstadual(inscricaoEstadual)
       .nomeEmpresarial(nomeEmpresarial)
       .nomeFantasia(nomeFantasia)
       .fone(fone)
       .foneAlternativo(foneAlternativo)
           .build();
   }

}
