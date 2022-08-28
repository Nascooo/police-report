package org.police.report.model;


import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@Component
@ManagedBean
public class ReportModelList {

    List<ReportModel> reportModels = new ArrayList<>();


    public List<ReportModel> getReportModels() {
        return reportModels;
    }

    public void setReportModels(List<ReportModel> reportModels) {
        this.reportModels = reportModels;
    }
}
