package org.police.report.model;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@Component
@ManagedBean
@SessionScoped
public class ReportModel {
    private Long reportId;
    private String title;
    private String details;

    private MultipartFile multipartFile;

    public ReportModel() {
    }

    public void reset() {
        reportId = null;
        title = null;
        details = null;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
