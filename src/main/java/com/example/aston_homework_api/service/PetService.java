package com.example.aston_homework_api.service;

import com.example.aston_homework_api.client.JsonHttpClient;
import com.example.aston_homework_api.data.PetType;
import com.example.aston_homework_api.dto.PetResponseDto;
import com.example.aston_homework_api.mapper.PetMapper;
import org.springframework.stereotype.Service;

import java.net.http.HttpClient;

@Service
public class PetService {
    PetMapper petMapper;
    JsonHttpClient client;

    public PetService(PetMapper petMapper, JsonHttpClient client) {
        this.petMapper = petMapper;
        this.client = client;
    }

    public PetResponseDto giveJsonResponse(String petType) {
        for (PetType type : PetType.values()) {
            if (petType.toUpperCase().equals(type.name())) {
                return petMapper.toDto(client.getPets(petType));
            }
        }
        return null;
    }
}
