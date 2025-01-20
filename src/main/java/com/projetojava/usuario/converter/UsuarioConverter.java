package com.projetojava.usuario.converter;


import com.projetojava.usuario.dto.EnderecoDTO;
import com.projetojava.usuario.dto.TelefoneDTO;
import com.projetojava.usuario.dto.UsuarioDTO;
import com.projetojava.usuario.infraestructure.entity.Endereco;
import com.projetojava.usuario.infraestructure.entity.Telefone;
import com.projetojava.usuario.infraestructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;


@Component

public class UsuarioConverter {



    public Usuario paraUsuario(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefones(usuarioDTO.getTelefones()))
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS) {
        return enderecoDTOS.stream().map(this::paraEndereco).toList();
        //Pode ser feito desta forma tambem
        //List<Endereco> enderecos = new ArrayList<
        //for(EnderecoDTO enderecoDTO : enderecoDTOS){
            //enderecos.add(paraEndereco(enderecoDTO));
        }

        public Endereco paraEndereco(EnderecoDTO enderecoDTO) {
            return Endereco.builder()
                    .rua(enderecoDTO.getRua())
                    .numero(enderecoDTO.getNumero())
                    .cidade(enderecoDTO.getCidade())
                    .complemento(enderecoDTO.getComplemento())
                    .cep(enderecoDTO.getCep())
                    .estado(enderecoDTO.getEstado())
                    .build();
        }

    public List<Telefone> paraListaTelefones(List<TelefoneDTO> telefoneDTOS) {
        return telefoneDTOS.stream().map(this::paraTelefones).toList();
    }

    public Telefone paraTelefones(TelefoneDTO telefoneDTO) {
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }
    public UsuarioDTO paraUsuarioDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .enderecos(paraListaEnderecoDTO(usuario.getEnderecos()))
                .telefones(paraListaTelefonesDTO(usuario.getTelefones()))
                .build();
    }
    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> endereco) {
        return endereco.stream().map(this::paraEnderecoDTO).toList();
    }
    public EnderecoDTO paraEnderecoDTO(Endereco endereco) {
        return EnderecoDTO.builder()
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .cidade(endereco.getCidade())
                .complemento(endereco.getComplemento())
                .cep(endereco.getCep())
                .estado(endereco.getEstado())
                .build();
    }
    public List<TelefoneDTO> paraListaTelefonesDTO(List<Telefone> telefone) {
        return telefone.stream().map(this::paraTelefonesDTO).toList();
    }

    public TelefoneDTO paraTelefonesDTO(Telefone telefone) {
        return TelefoneDTO.builder()
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }
}