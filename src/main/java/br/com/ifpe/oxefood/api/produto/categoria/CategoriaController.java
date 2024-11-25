package br.com.ifpe.oxefood.api.produto.categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.produto.categoria.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.produto.categoria.CategoriaProdutoRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/produto/categoria")
@CrossOrigin
public class CategoriaController {
    @Autowired
    CategoriaProdutoRepository categoriaProdutoRepository;

    @GetMapping("{id}")
    @Transactional
    public CategoriaProduto get(@RequestParam Long id) {
        return categoriaProdutoRepository.findById(id).get();
    }

    @PostMapping()
    @Transactional
    public CategoriaProduto post(@RequestBody CategoriaProduto entity) {
        entity.setHabilitado(true);
        return categoriaProdutoRepository.save(entity);
    }

    @PutMapping("{id}")
    @Transactional
    public CategoriaProduto put(@PathVariable Long id, @RequestBody CategoriaProduto entity) {
        Optional<CategoriaProduto> c = categoriaProdutoRepository.findById(id);
        if(c.isPresent()){
            CategoriaProduto temp = c.get();
            temp.setDescricao(entity.getDescricao());
            return categoriaProdutoRepository.save(temp);
        }else{
            return null;
        }
        
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<CategoriaProduto> c = categoriaProdutoRepository.findById(id);
        if (c.isPresent()) {
            categoriaProdutoRepository.delete(c.get());
            return ResponseEntity.ok().body("Categoria deletada");
        } else {
            return ResponseEntity.status(404).body("Not found");
        }
    }
    @GetMapping()
    public List<CategoriaProduto> getAll() {
        return categoriaProdutoRepository.findAll();
    }
    

}
