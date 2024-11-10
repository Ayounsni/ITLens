package com.it.itlens.services.implementation;

import com.it.itlens.models.mappers.GenericMapper;
import com.it.itlens.services.interfaces.IGenericService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class GenericService<Entity, CreateDTO, UpdateDTO, ResponseDTO> implements IGenericService<CreateDTO, UpdateDTO, ResponseDTO> {

    protected final JpaRepository<Entity, Long> repository;
    protected final GenericMapper<Entity, CreateDTO, UpdateDTO, ResponseDTO> mapper;

    public GenericService(JpaRepository<Entity, Long> repository, GenericMapper<Entity, CreateDTO,UpdateDTO, ResponseDTO> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ResponseDTO create(CreateDTO createDTO) {
        Entity entity = mapper.toEntity(createDTO);
        Entity savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    @Override
    public ResponseDTO findById(Long id) {
        Entity entity = repository.findById(id).orElseThrow();
        return mapper.toDTO(entity);
    }

    @Override
    public List<ResponseDTO> findAll() {
        List<Entity> entities = repository.findAll();
        return entities.stream().map(mapper::toDTO).toList();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ResponseDTO update(Long id, UpdateDTO updateDTO) {
        Entity entity = repository.findById(id).orElseThrow();
        Entity updatedEntity = mapper.updateEntityFromDTO(updateDTO, entity);
        updatedEntity = repository.save(updatedEntity);
        return mapper.toDTO(updatedEntity);
    }
}
