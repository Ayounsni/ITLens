package com.it.itlens.services.implementation;

import com.it.itlens.mappers.OwnerMapper;
import com.it.itlens.models.dtos.Owner.CreateOwnerDTO;
import com.it.itlens.models.dtos.Owner.ResponseOwnerDTO;
import com.it.itlens.models.dtos.Owner.UpdateOwnerDTO;
import com.it.itlens.models.entities.Owner;
import com.it.itlens.repository.OwnerRepository;
import com.it.itlens.services.interfaces.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService implements IOwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public ResponseOwnerDTO addOwner(CreateOwnerDTO createOwnerDTO) {
        Owner owner = ownerMapper.toEntity(createOwnerDTO);
        Owner savedOwner = ownerRepository.save(owner);
        return ownerMapper.toDTO(savedOwner);
    }
    @Override
    public ResponseOwnerDTO getOwnerById(Long id) {
      Owner owner = ownerRepository.findById(id).orElse(null);
      return ownerMapper.toDTO(owner);
    }
    @Override
    public List<ResponseOwnerDTO> getAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        return ownerMapper.toDTOs(owners);
    }

    @Override
    public void deleteOwnerById(Long id) {
        ownerRepository.deleteById(id);
    }



}
