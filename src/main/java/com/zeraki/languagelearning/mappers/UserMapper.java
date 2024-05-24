package com.zeraki.languagelearning.mappers;

import com.zeraki.languagelearning.dto.UserCreateDto;
import com.zeraki.languagelearning.dto.UserDto;
import com.zeraki.languagelearning.entities.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);

    User userCreateDTOToUser(UserCreateDto userCreateDTO);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);

    User toEntity(UserDto userDto);
}