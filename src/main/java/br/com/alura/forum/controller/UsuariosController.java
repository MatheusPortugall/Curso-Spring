package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.dto.UsuarioDto;
import br.com.alura.forum.controller.form.UsuarioForm;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuarioRepository;

    @GetMapping
    public List<UsuarioDto> lista() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioDto.converter(usuarios);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioForm form, UriComponentsBuilder uriBuilder){
        Usuario usuario = form.converter();
        usuarioRepository.save(usuario);
        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
    }
}
