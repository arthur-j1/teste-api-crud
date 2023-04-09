package br.com.apicrud.teste.controller;

import br.com.apicrud.teste.entity.Usuario;
import br.com.apicrud.teste.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UsuarioController {
    @Autowired
    UsuarioService service;

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> buscarTodos(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("buscar_usuario/{id}")
    public ResponseEntity<Usuario> buscarPeloId(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id).orElse(null));
    }

    @PostMapping("/salvar_usuario")
    public ResponseEntity<Usuario> salvar(@RequestBody @Validated Usuario usuario){
        return ResponseEntity.ok(service.save(usuario));
    }

    @DeleteMapping("/remover/{id}")
    public void apagar(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        return ResponseEntity.ok(service.update(id,usuario).orElse(null));
    }

}