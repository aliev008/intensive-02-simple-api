package com.example.aston_homework_api.mapper;

import com.example.aston_homework_api.dto.PetResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class PetMapper {
    public PetResponseDto toDto(String response) {

        var jacksonMapper = new ObjectMapper();

        PetResponseDto petResponseDto;

        try {
            petResponseDto = jacksonMapper.readValue(response, PetResponseDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(petResponseDto);

        return petResponseDto;
    }
}
