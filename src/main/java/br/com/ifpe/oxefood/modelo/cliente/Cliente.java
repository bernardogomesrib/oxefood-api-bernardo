package br.com.ifpe.oxefood.modelo.cliente;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.cliente.endereco.Endereco;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cliente")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel {

   @Column(nullable = false,length = 100)
   private String nome;
   @Column(nullable = false)
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;
   @Column(nullable = false, length = 14, unique = true)
   private String cpf;
   @Column(nullable = false, length = 20)
   private String foneCelular;
   @Column(length = 20)
   private String foneFixo;
   @OneToMany(mappedBy = "cliente", orphanRemoval = true, fetch = FetchType.EAGER)
   private List<Endereco> enderecos;
   
   @OneToOne
   @JoinColumn(nullable = false)
   private Usuario usuario;

}
