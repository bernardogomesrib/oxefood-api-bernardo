package br.com.ifpe.oxefood.modelo.empresa;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends EntidadeAuditavel {
    @Column
    private String site;
    @Column
    private String cnpj;
    @Column
    private String inscricaoEstadual;
    @Column
    private String nomeEmpresarial;
    @Column
    private String nomeFantasia;
    @Column
    private String fone;
    @Column
    private String foneAlternativo;
}
