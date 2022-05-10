package com.uploadImage.UploadImage.Services.imple;

import com.uploadImage.UploadImage.Services.fileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class fileServiceImple implements fileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        //file name
        String name = file.getOriginalFilename();

        String randomID = UUID.randomUUID().toString();
        String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));
        //full path
        String filePath = path + File.separator + fileName1;
        //create folder if not
        File f = new File(path);
        if (!f.exists()){
            f.mkdir();
        }
        //file copy
        Files.copy(file.getInputStream(), Paths.get(filePath));
        return fileName1;
    }
}
