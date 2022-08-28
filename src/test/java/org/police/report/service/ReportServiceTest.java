package org.police.report.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.police.report.entities.Report;
import org.police.report.mappers.ReportMapper;
import org.police.report.model.ReportModel;
import org.police.report.repository.ReportRepository;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ReportServiceTest {

    public static final String TITLE = "Title";
    public static final String DETAILS = "DETAILS";
    @Mock
    private ReportRepository reportRepository;

    @Mock
    private ReportMapper reportMapper;

    @InjectMocks
    private ReportService reportService;

    @Mock
    private ReportModel reportModel;


    @Test
    public void testResetFormAfterAddReport() {
        reportModel.setTitle(TITLE);
        reportModel.setDetails(DETAILS);
        when(reportMapper.fromReportModelToEntity(any())).thenReturn(new Report());
        when(reportRepository.save(any())).thenReturn(new Report());
        when(reportMapper.fromEntityToReportModel(any())).thenReturn(reportModel);
        ReportModel model = reportService.addReport(reportModel);
        verify(reportModel, times(1)).reset();
    }
}