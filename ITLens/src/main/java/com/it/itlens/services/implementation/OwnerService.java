package com.it.itlens.services.implementation;

import com.it.itlens.models.mappers.OwnerMapper;
import com.it.itlens.models.dtos.Owner.CreateOwnerDTO;
import com.it.itlens.models.dtos.Owner.ResponseOwnerDTO;
import com.it.itlens.models.dtos.Owner.UpdateOwnerDTO;
import com.it.itlens.models.entities.Owner;
import com.it.itlens.repository.OwnerRepository;
import com.it.itlens.services.interfaces.IOwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerService extends GenericService<Owner,CreateOwnerDTO,UpdateOwnerDTO,ResponseOwnerDTO> implements IOwnerService {

    private final OwnerMapper ownerMapper;

    public OwnerService(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
        super(ownerRepository);
        this.ownerMapper = ownerMapper;
    }

    @Override
    protected Owner toEntity(CreateOwnerDTO createOwnerDTO) {
        return ownerMapper.toEntity(createOwnerDTO);
    }

    @Override
    protected ResponseOwnerDTO toResponseDTO(Owner owner) {
        return ownerMapper.toDTO(owner);
    }

    @Override
    protected void updateEntityFromDTO(UpdateOwnerDTO updateOwnerDTO, Owner owner) {
        ownerMapper.updateOwnerFromDto(updateOwnerDTO, owner);
    }



}
