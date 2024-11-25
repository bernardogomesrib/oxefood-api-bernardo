package br.com.ifpe.oxefood.modelo.cliente.endereco;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco extends EntidadeAuditavel {
    @ManyToOne
    @JsonIgnore
    private Cliente cliente;
    @Column
    private String rua;
    @Column
    private String numero;
    @Column
    private String bairro;
    @Column
    private String cep;
    @Column
    private String cidade;
    @Column
    private String estado;
    @Column
    private String complemento;
}
