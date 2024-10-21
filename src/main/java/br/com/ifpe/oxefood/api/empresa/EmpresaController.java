package br.com.ifpe.oxefood.api.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.empresa.Empresa;
import br.com.ifpe.oxefood.modelo.empresa.EmpresaService;

@RestController
@RequestMapping("/api/empresa")
@CrossOrigin
public class EmpresaController {

   @Autowired
   private EmpresaService EmpresaService;

   @PostMapping
   public ResponseEntity<Empresa> save(@RequestBody EmpresaRequest request) {

       Empresa Empresa = EmpresaService.salvar(request.build());
       return new ResponseEntity<Empresa>(Empresa, HttpStatus.CREATED);
   }
}
