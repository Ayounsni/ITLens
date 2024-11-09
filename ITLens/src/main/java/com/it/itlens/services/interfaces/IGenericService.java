package com.it.itlens.services.interfaces;

import java.util.List;

public interface IGenericService<CreateDTO, UpdateDTO, ResponseDTO> {
    ResponseDTO create(CreateDTO createDTO);
    ResponseDTO findById(Long id);
    List<ResponseDTO> findAll();
    void deleteById(Long id);
    ResponseDTO update(Long id, UpdateDTO updateDTO);
}

