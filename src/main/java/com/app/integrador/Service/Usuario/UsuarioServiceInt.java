package com.app.integrador.Service.Usuario;

import com.app.integrador.Entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioServiceInt {
    Usuario saveUser(Usuario usuario);
    Optional<Usuario> findById(Integer id);
    Usuario updateUser(Usuario usuario);
    List<Usuario> all();
    void deleteById(Integer id);

}
