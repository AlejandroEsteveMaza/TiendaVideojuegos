package com.example.tiendavideojuegos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.tiendavideojuegos.service.ImageUploadingService;

@RestController
@RequestMapping("/img")
public class ImageController {

	@Autowired
    ImageUploadingService imageService;

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        return imageService.upload(multipartFile);
    }
}