package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Transactional
    public Produto salvar(Produto produto) {
        produto.setHabilitado(true);
        produto.setVersao(1L);
        //produto.setDataCriacao(LocalDate.now());
        return produtoRepository.save(produto);
         
    }
    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }
    public Produto obterPorID(Long id){
        return produtoRepository.findById(id).orElseThrow();
    }
}
