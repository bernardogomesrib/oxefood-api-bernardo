package br.com.ifpe.oxefood.util.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntidadeAuditavel extends EntidadeNegocio {
    
   @JsonIgnore
   @Version
   private Long versao;

   @JsonIgnore
   @CreatedDate
   @Column(nullable = false, updatable = false)
   private LocalDateTime dataCriacao;

   @JsonIgnore
   @LastModifiedDate
   @Column(insertable = false)
   private LocalDateTime dataUltimaModificacao;

   @JsonIgnore
   @Column
   private Long criadoPor; // Id do usuário que o criou

   @JsonIgnore
   @Column
   private Long ultimaModificacaoPor; // Id do usuário que fez a última alteração

}
