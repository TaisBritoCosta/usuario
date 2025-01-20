package com.projetojava.usuario.business;


import com.projetojava.usuario.converter.UsuarioConverter;
import com.projetojava.usuario.dto.UsuarioDTO;
import com.projetojava.usuario.infraestructure.entity.Usuario;
import com.projetojava.usuario.infraestructure.repository.UsuarioRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    //    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
//        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
//        usuario = usuarioRepository.save(usuario);  // Correção: Atribui o objeto persistido
//        return usuarioConverter.paraUsuarioDTO(usuario);
//    }
    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }
}


