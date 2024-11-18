package br.com.ifpe.oxefood.modelo.configuracaosistema;
import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Empresa")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfiguracaoSistema extends EntidadeAuditavel{
    private String nomeEmpresa;
    private String cnpj;
    private String site;
    private String emailContato;
    private Long tempoMinimoAgendamentoPedidos;
    private boolean ligarAceitePedidos;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntradaSistema;
}
