package org.police.report.service;

import org.apache.catalina.core.ApplicationPart;
import org.police.report.entities.File;
import org.police.report.mappers.FileMapper;
import org.police.report.model.FileUploadView;
import org.police.report.repository.FileRepository;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialBlob;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class FileUploadService {

    private FileRepository fileRepository;

    private FileMapper fileMapper;

    public FileUploadService(FileRepository fileRepository, FileMapper fileMapper) {
        this.fileRepository = fileRepository;
        this.fileMapper = fileMapper;
    }

    public void upload(ApplicationPart part) {
        if (part != null) {
            try {
                InputStream inputStream = part.getInputStream();
                String fileContent = new Scanner(inputStream)
                        .useDelimiter("\\A").next();
                System.out.println(fileContent.length());
                byte[] byteData = fileContent.getBytes();
                File file = new File();
                file.setFile(new SerialBlob(byteData));
                file.setFileName(part.getSubmittedFileName());
                fileRepository.save(file);
                part = null;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public List<FileUploadView> getUploadedFiles() {
        List<File> fileList = fileRepository.findAll();
        return fileList.stream().map(fileMapper::fromFileToFileView).collect(Collectors.toList());
    }
}
