package com.cocode.controller;

import com.cocode.model.dto.DificultadDto;
import com.cocode.model.entity.Dificultad;
import com.cocode.model.payload.ResponseMessage;
import com.cocode.service.IDificultad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DificultadController {

    @Autowired
    private IDificultad dificultadService;

    @GetMapping("dificultad")
    public ResponseEntity<?> showAll() {
        List<Dificultad> getList = dificultadService.listAll();

        if (getList == null) {
            return new ResponseEntity<>(ResponseMessage.builder().message("No se encontró ningún elemento")
                    .object(null).build(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResponseMessage.builder().message("")
                .object(getList).build(), HttpStatus.OK);
    }

    @GetMapping("dificultad/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        Dificultad dificultad = dificultadService.findById(id);

        if (dificultad == null) {
            return new ResponseEntity<>(ResponseMessage.builder().message("El registro que estás buscando no ha podido ser encontrado")
                    .object(null).build(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ResponseMessage.builder().message("").object(
                DificultadDto.builder()
                        .id(dificultad.getId())
                        .nombre(dificultad.getNombre())
                        .build()
        ).build(), HttpStatus.OK);
    }
}