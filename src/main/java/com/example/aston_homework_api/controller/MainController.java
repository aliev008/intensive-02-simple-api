package com.example.aston_homework_api.controller;

import com.example.aston_homework_api.dto.PetResponseDto;
import com.example.aston_homework_api.service.PetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MainController {
    PetService petService;

    public MainController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/api/pets")
    public PetResponseDto getPetByType(
            @RequestParam String petType
    ) {
        return petService.giveJsonResponse(petType);
    }
}
