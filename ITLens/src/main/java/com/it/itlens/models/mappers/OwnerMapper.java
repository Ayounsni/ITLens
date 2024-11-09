package com.it.itlens.models.mappers;

import com.it.itlens.models.dtos.Owner.CreateOwnerDTO;
import com.it.itlens.models.dtos.Owner.ResponseOwnerDTO;
import com.it.itlens.models.dtos.Owner.UpdateOwnerDTO;
import com.it.itlens.models.entities.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OwnerMapper {
    Owner toEntity(CreateOwnerDTO createOwnerDTO);

    ResponseOwnerDTO toDTO(Owner owner);

    List<ResponseOwnerDTO> toDTOs(List<Owner> owners);

    void updateOwnerFromDto(UpdateOwnerDTO updateOwnerDTO, @MappingTarget Owner owner);
}