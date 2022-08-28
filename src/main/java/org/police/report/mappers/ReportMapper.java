package org.police.report.mappers;

import org.police.report.entities.Report;
import org.police.report.model.ReportModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    ReportModel fromEntityToReportModel(Report report);

    Report fromReportModelToEntity(ReportModel report);

}
