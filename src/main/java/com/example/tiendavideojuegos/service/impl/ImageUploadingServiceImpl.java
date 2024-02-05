package com.example.tiendavideojuegos.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.tiendavideojuegos.service.ImageUploadingService;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@Service
public class ImageUploadingServiceImpl implements ImageUploadingService {

	@Override
	public File convertToFile(MultipartFile multipartFile, String fileName) throws IOException {
		File tempFile = new File(fileName);
		try (FileOutputStream fos = new FileOutputStream(tempFile)) {
			fos.write(multipartFile.getBytes());
			fos.close();
		}
		return tempFile;
	}

	@Override
	public String uploadFile(File file, String fileName) throws IOException {
		BlobId blobId = BlobId.of("tiendavideojuegos-8434f.appspot.com", fileName);
		BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
		FileInputStream inputStream = new FileInputStream(
				"src/main/resources/tiendavideojuegos-8434f-firebase-adminsdk-4u5gi-18a778fc7e.json");
		Credentials credentials = GoogleCredentials.fromStream(inputStream);
		Storage storage = StorageOptions.newBuilder().setProjectId("tiendavideojuegos-8434f")
				.setCredentials(credentials).build().getService();
		System.out.print(file.toPath());
		storage.create(blobInfo, Files.readAllBytes(file.toPath()));

		String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/tiendavideojuegos-8434f.appspot.com/o/%s?alt=media";
		return String.format(DOWNLOAD_URL, URLEncoder.encode(fileName, StandardCharsets.UTF_8));
	}

	@Override
	public String getExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	@Override
	public String upload(MultipartFile multipartFile) {
		try {
			String fileName = multipartFile.getOriginalFilename(); // to get original file name
			fileName = UUID.randomUUID().toString().concat(this.getExtension(fileName)); // to generated random string
																							// values for file name.

			File file = this.convertToFile(multipartFile, fileName); // to convert multipartFile to File
			String URL = this.uploadFile(file, fileName); // to get uploaded file link
			file.delete();
			return URL;
		} catch (Exception e) {
			e.printStackTrace();
			return "Image couldn't upload, Something went wrong: ";
		}
	}

}
