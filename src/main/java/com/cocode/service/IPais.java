package com.cocode.service;

import com.cocode.model.entity.Pais;

import java.util.List;

public interface IPais {

    List<Pais> listAll();

    Pais findById(Long id);
}
