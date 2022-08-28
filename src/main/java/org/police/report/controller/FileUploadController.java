package org.police.report.controller;

import org.apache.catalina.core.ApplicationPart;
import org.police.report.entities.File;
import org.police.report.model.FileUploadView;
import org.police.report.repository.FileRepository;
import org.police.report.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Controller
@ManagedBean
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    public void upload(ApplicationPart part) {
        fileUploadService.upload(part);
        getUploadedFiles();
    }

    public List<FileUploadView> getUploadedFiles(){
        return fileUploadService.getUploadedFiles();
    }
}
