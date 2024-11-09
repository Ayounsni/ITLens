package com.it.itlens.services.implementation;

import com.it.itlens.services.interfaces.IGenericService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public abstract class GenericService<Entity, CreateDTO, UpdateDTO, ResponseDTO> implements IGenericService<CreateDTO, UpdateDTO, ResponseDTO> {

    protected final JpaRepository<Entity, Long> repository;

    public GenericService(JpaRepository<Entity, Long> repository) {
        this.repository = repository;
    }

    protected abstract Entity toEntity(CreateDTO createDTO);
    protected abstract ResponseDTO toResponseDTO(Entity entity);
    protected abstract void updateEntityFromDTO(UpdateDTO updateDTO, Entity entity);

    @Override
    public ResponseDTO create(CreateDTO createDTO) {
        Entity entity = toEntity(createDTO);
        Entity savedEntity = repository.save(entity);
        return toResponseDTO(savedEntity);
    }

    @Override
    public ResponseDTO findById(Long id) {
        Entity entity = repository.findById(id).orElseThrow();
        return toResponseDTO(entity);
    }

    @Override
    public List<ResponseDTO> findAll() {
        List<Entity> entities = repository.findAll();
        return entities.stream().map(this::toResponseDTO).toList();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ResponseDTO update(Long id, UpdateDTO updateDTO) {
        Entity entity = repository.findById(id).orElseThrow();
        updateEntityFromDTO(updateDTO, entity);
        Entity updatedEntity = repository.save(entity);
        return toResponseDTO(updatedEntity);
    }
}
