package com.uploadImage.UploadImage.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface fileService {
    String uploadImage(String path, MultipartFile file) throws IOException;
}
