package org.police.report.controller;

import org.police.report.model.ReportModel;
import org.police.report.service.ReportService;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;
import java.util.List;

@Controller
@ManagedBean
public class ReportController {

    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    public List<ReportModel> getModels() {
        return reportService.getAllReportsToView();
    }

    public ReportModel addReport(ReportModel reportModel) {
        return reportService.addReport(reportModel);
    }

    public void delete(Long id, ReportModel reportModel) {
        reportService.delete(id);
        reset(reportModel);
    }

    public ReportModel edit(ReportModel reportModel, Long id) {
        return reportService.update(reportModel, id);
    }

    public void log() {
        System.out.println(System.nanoTime());
    }

    public void reset(ReportModel reportModel) {
        reportModel.reset();
    }

    public void fileUploadListener(FileUploadEvent e){
        // Get uploaded file from the FileUploadEvent
        UploadedFile file = e.getFile();
        // Print out the information of the file
        System.out.println("Uploaded File Name Is :: "+file.getFileName()+" :: Uploaded File Size :: "+file.getSize());
    }
}
