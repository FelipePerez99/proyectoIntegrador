package com.app.integrador.Controller;

import com.app.integrador.Entity.Usuario;
import com.app.integrador.Service.Usuario.UsuarioServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioServiceInt usuarioServiceInt;

    public UsuarioController(@Autowired UsuarioServiceInt usuarioServiceInt) {
        this.usuarioServiceInt = usuarioServiceInt;
    }


    @PostMapping
    public ResponseEntity<Usuario> addUser(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioServiceInt.saveUser(usuario), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findUserById(@PathVariable Integer id){
        Optional<Usuario> usuario = usuarioServiceInt.findById(id);
        return new ResponseEntity<>(usuario, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<?> allUser(){
        List<Usuario> users = usuarioServiceInt.all();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        usuarioServiceInt.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario updatedUser = usuarioServiceInt.updateUser(usuario);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
