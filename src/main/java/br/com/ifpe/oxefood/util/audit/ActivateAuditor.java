package br.com.ifpe.oxefood.util.audit;

import org.springframework.context.annotation.Configuration;
/* 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; */
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//import br.com.ifpe.oxefood.modelo.acesso.Usuario;

@Configuration
@EnableJpaAuditing
public class ActivateAuditor {

   //@Bean
    public AuditorAware<?> auditorProvider() {
        return new ApplicationAuditorAware();
    }
}