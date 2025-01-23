package com.projetojava.usuario.business;


import com.projetojava.usuario.converter.UsuarioConverter;
import com.projetojava.usuario.dto.UsuarioDTO;
import com.projetojava.usuario.infraestructure.entity.Usuario;
import com.projetojava.usuario.infraestructure.exceptions.ConflictException;
import com.projetojava.usuario.infraestructure.repository.UsuarioRepository;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Getter
@Setter
@AllArgsConstructor
@Table(name = "usuario")
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;
    private final PasswordEncoder passwordEncoder;

//    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
//        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
//        usuario = usuarioRepository.save(usuario);  // Correção: Atribui o objeto persistido
//        return usuarioConverter.paraUsuarioDTO(usuario);
//    }
    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        emailExiste(usuarioDTO.getEmail());
        usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }
    public void emailExiste(String email){
        try{
            boolean existe = verificaEmailExistente(email);
            if(existe){
                throw new ConflictException("Email já cadastrado" + email);
            }
        }catch (ConflictException e){
            throw new ConflictException("Email já cadastrado", e.getCause());
        }
    }

    public boolean verificaEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }
}


