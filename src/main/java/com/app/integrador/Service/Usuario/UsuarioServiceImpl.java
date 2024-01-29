package com.app.integrador.Service.Usuario;

import com.app.integrador.Entity.Usuario;
import com.app.integrador.Exception.UsuarioNotFoundException;
import com.app.integrador.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioServiceInt {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(@Autowired UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario saveUser(Usuario usuario) {
        Usuario newUser = usuarioRepository.save(usuario);
        if(newUser != null){
            return newUser;
        }else{
            throw new UsuarioNotFoundException();
        }
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        Optional<Usuario> user = usuarioRepository.findById(id);
        if (user.isPresent()){
            return user;
        }else{
            throw new UsuarioNotFoundException();
        }
    }

    @Override
    public Usuario updateUser(Usuario usuario) {
        Integer userId = usuario.getId();
        Usuario existingUser = usuarioRepository.findById(userId).orElseThrow(UsuarioNotFoundException::new);

        existingUser.setNombre(usuario.getNombre());
        existingUser.setIdentificacion(usuario.getIdentificacion());
        existingUser.setApellido(usuario.getApellido());
        existingUser.setCorreo(usuario.getCorreo());
        return usuarioRepository.save(existingUser);
    }

    @Override
    public List<Usuario> all() {
        List<Usuario> users = usuarioRepository.findAll();
        if (users.isEmpty()){
            throw new UsuarioNotFoundException();
        }
        return users;
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Usuario> user = usuarioRepository.findById(id);
        if (user.isPresent()){
            usuarioRepository.deleteById(id);
        }else{
            throw new UsuarioNotFoundException();
        }
    }
}
