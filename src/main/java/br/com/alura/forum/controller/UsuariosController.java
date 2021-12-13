package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.UsuarioDto;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuariosController {

    @Autowired
    private UsuariosRepository usuarioRepository;

    @RequestMapping("/usuarios")
    public List<UsuarioDto> lista() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioDto.converter(usuarios);
    }
}
