package com.example.tiendavideojuegos.service;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadingService {

	public File convertToFile(MultipartFile multipartFile, String fileName) throws IOException;
	
	public String uploadFile(File file, String fileName) throws IOException;
	
	public String getExtension(String fileName);
	
	public String upload(MultipartFile multipartFile);
	
}
