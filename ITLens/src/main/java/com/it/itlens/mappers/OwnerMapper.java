package com.it.itlens.mappers;

import com.it.itlens.models.dtos.Owner.CreateOwnerDTO;
import com.it.itlens.models.dtos.Owner.ResponseOwnerDTO;
import com.it.itlens.models.entities.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OwnerMapper {
    Owner toEntity(CreateOwnerDTO createOwnerDTO);

    ResponseOwnerDTO toDTO(Owner owner);

    List<ResponseOwnerDTO> toDTOs(List<Owner> teams);
}
