package com.pratyush.springcouchbase.utility;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.pratyush.springcouchbase.dto.EmployeeDTO;
import com.pratyush.springcouchbase.entity.EmployeeEntity;

@Mapper
public interface SourceDestinationMapper {

	SourceDestinationMapper INSTANCE = Mappers.getMapper(SourceDestinationMapper.class);

	EmployeeDTO toEmployeeDTO(EmployeeEntity employeeEntity);

	EmployeeEntity toEmployeeEntity(EmployeeDTO employeeDTO);

}
