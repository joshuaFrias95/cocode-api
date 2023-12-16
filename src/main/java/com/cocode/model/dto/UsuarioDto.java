package com.cocode.model.dto;

import com.cocode.model.entity.Pais;
import com.cocode.model.entity.Proyecto;
import com.cocode.model.entity.Tecnologia;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Builder
public class UsuarioDto implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Pais pais;
    private String descripcion;
    private String rol;
    private String avatar;
    private Integer puntos;

    private List<Tecnologia> tecnologias;
    private List<Proyecto> proyectos;
    private List<Proyecto> proyectosFavoritos;
}
