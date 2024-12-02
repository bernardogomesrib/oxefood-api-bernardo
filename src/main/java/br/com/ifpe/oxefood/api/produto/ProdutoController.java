package br.com.ifpe.oxefood.api.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;
import br.com.ifpe.oxefood.modelo.produto.categoria.CategoriaProdutoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

   @Autowired
   private ProdutoService ProdutoService;
   @Autowired
   private CategoriaProdutoRepository categoriaProdutoRepository;

   @PostMapping
   public ResponseEntity<Produto> save(@RequestBody @Valid ProdutoRequest request) {

       Produto Produto = ProdutoService.salvar(request.build(),request.getCategoriaId());
       return new ResponseEntity<Produto>(Produto, HttpStatus.CREATED);
   }
   @GetMapping
    public List<Produto> listarTodos() {
        return ProdutoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto obterPorID(@PathVariable Long id) {
        return ProdutoService.obterPorID(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id,@Valid @RequestBody ProdutoRequest request) {
        Produto p = request.build();
        p.setCategoria(categoriaProdutoRepository.findById(request.getCategoriaId()).get());
        System.out.println(p.getCategoria().getDescricao());
        ProdutoService.update(id, p);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> delete(@PathVariable("id") Long id) {
        ProdutoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
