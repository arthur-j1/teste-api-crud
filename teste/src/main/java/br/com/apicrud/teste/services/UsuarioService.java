package br.com.apicrud.teste.services;

import br.com.apicrud.teste.entity.Usuario;
import br.com.apicrud.teste.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    public List<Usuario> getAll(){
       return repository.findAll();
    }

    public Optional<Usuario> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Optional<Usuario> update(Long id,Usuario novoUsuario){
        Optional<Usuario> usuarioBanco = repository.findById(id);
        if (usuarioBanco.isPresent()){
            if (novoUsuario.getNome() != null){
                usuarioBanco.get().setNome(novoUsuario.getNome());
            }if (novoUsuario.getSenha() != null){
                usuarioBanco.get().setSenha(novoUsuario.getSenha());
            }
            repository.save(usuarioBanco.get());
        }return usuarioBanco;

    }

    public Usuario save(Usuario usuario){
        return repository.save(usuario);
    }



}