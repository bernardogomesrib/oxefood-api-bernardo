package br.com.ifpe.oxefood.util.audit;


import org.springframework.data.domain.AuditorAware;

/* import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
 */
import br.com.ifpe.oxefood.modelo.acesso.Usuario;

//@Configuration
//@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class ActivateAuditor {

    /* @Bean */
    public AuditorAware<Usuario> auditorProvider() {
        return new ApplicationAuditorAware();
    }
}