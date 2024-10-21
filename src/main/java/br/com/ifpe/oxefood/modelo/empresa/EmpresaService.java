package br.com.ifpe.oxefood.modelo.empresa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository EmpresaRepository;
    @Transactional
    public Empresa salvar(Empresa empresa) {
        empresa.setHabilitado(true);
        empresa.setVersao(1L);
        empresa.setDataCriacao(LocalDate.now());
        return EmpresaRepository.save(empresa);
    }
}
