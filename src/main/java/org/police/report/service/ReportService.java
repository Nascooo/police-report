package org.police.report.service;

import org.police.report.mappers.ReportMapper;
import org.police.report.entities.Report;
import org.police.report.model.ReportModel;
import org.police.report.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private ReportRepository reportRepository;

    private ReportMapper reportMapper;


    public ReportService(ReportRepository reportRepository, ReportMapper reportMapper) {
        this.reportRepository = reportRepository;
        this.reportMapper = reportMapper;
    }

    public List<ReportModel> getAllReportsToView() {
        return getAllEntities().stream().map(reportMapper::fromEntityToReportModel).collect(Collectors.toList());
    }

    public List<Report> getAllEntities() {
        return reportRepository.findAll();
    }

    public ReportModel addReport(ReportModel reportModel) {
        Report report = reportMapper.fromReportModelToEntity(reportModel);
        reportModel.reset();
        return reportMapper.fromEntityToReportModel(reportRepository.save(report));
    }

    public void delete(Long id) {
        reportRepository.deleteById(id);
    }

    public ReportModel update(ReportModel reportModel, Long reportId) {
        Report optionalReport = reportRepository.findById(reportId).get();
        reportModel.setReportId(optionalReport.getReportId());
        reportModel.setDetails(optionalReport.getDetails());
        reportModel.setTitle(optionalReport.getTitle());
        return reportModel;
    }

    public void resetModel(ReportModel reportModel) {
        reportModel.reset();
    }
}
