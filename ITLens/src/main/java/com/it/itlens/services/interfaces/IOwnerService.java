package com.it.itlens.services.interfaces;

import com.it.itlens.models.dtos.Owner.CreateOwnerDTO;
import com.it.itlens.models.dtos.Owner.ResponseOwnerDTO;

import java.util.List;

public interface IOwnerService {
    ResponseOwnerDTO addOwner(CreateOwnerDTO createOwnerDTO);
    ResponseOwnerDTO getOwnerById(Long id);
    List<ResponseOwnerDTO> getAllOwners();
    void deleteOwnerById(Long id);
}
