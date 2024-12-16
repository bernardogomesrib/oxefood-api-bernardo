package br.com.ifpe.oxefood.util.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class ApplicationAuditorAware implements AuditorAware<String> {
    
    public @NonNull Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken) {
            throw new IllegalStateException("Não foi possível recuperar o usuário logado.");
        }

        // User userPrincipal = (User) authentication.getPrincipal();
        System.out.println("NOME DO MALDITO!" + authentication.getName());
        return Optional.ofNullable(authentication.getName());
    }
}