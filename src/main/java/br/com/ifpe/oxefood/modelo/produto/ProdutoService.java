package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.modelo.produto.categoria.CategoriaProdutoRepository;
import br.com.ifpe.oxefood.util.exception.ProdutoException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;
    @Transactional
    public Produto salvar(Produto produto,Long id) {
        if(produto.getValorUnitario() < 10) {
            throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO);
        }
        produto.setHabilitado(true);
        produto.setCategoria(categoriaProdutoRepository.findById(id).get());
        return produtoRepository.save(produto);

    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto obterPorID(Long id) {
        return produtoRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Produto update(Long id, Produto ProdutoAlterado) {
        Produto Produto = produtoRepository.findById(id).get();
        /* Produto.setEmpresa(ProdutoAlterado.getEmpresa()); */
        Produto.setCategoria(ProdutoAlterado.getCategoria());
        Produto.setCodigo(ProdutoAlterado.getCodigo());
        Produto.setTitulo(ProdutoAlterado.getTitulo());
        Produto.setDescricao(ProdutoAlterado.getDescricao());
        Produto.setValorUnitario(ProdutoAlterado.getValorUnitario());
        Produto.setTempoEntregaMaximo(ProdutoAlterado.getTempoEntregaMaximo());
        Produto.setTempoEntregaMinimo(ProdutoAlterado.getTempoEntregaMinimo());
        return produtoRepository.save(Produto);
    }
    @Transactional
    public void delete(Long id) {
        Produto Produto = produtoRepository.findById(id).get();
        Produto.setHabilitado(false);
        produtoRepository.save(Produto);
    }


    public List<Produto> filtrar(String codigo, String titulo, Long idCategoria) {

        List<Produto> listaProdutos;
 
        if ((codigo != null && !"".equals(codigo)) &&
            (titulo == null || "".equals(titulo)) &&
            (idCategoria == null)) {
                listaProdutos = produtoRepository.consultarPorCodigo(codigo);
        } else if (
            (codigo == null || "".equals(codigo)) &&
            (titulo != null && !"".equals(titulo)) &&
            (idCategoria == null)) {    
                listaProdutos = produtoRepository.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo);
        } else if (
            (codigo == null || "".equals(codigo)) &&
            (titulo == null || "".equals(titulo)) &&
            (idCategoria != null)) {
                listaProdutos = produtoRepository.consultarPorCategoria(idCategoria); 
        } else if (
            (codigo == null || "".equals(codigo)) &&
            (titulo != null && !"".equals(titulo)) &&
            (idCategoria != null)) {
                listaProdutos = produtoRepository.consultarPorTituloECategoria(titulo, idCategoria); 
        }else{
            listaProdutos = produtoRepository.findAll();
        }
 
        return listaProdutos;
 }
 
}
