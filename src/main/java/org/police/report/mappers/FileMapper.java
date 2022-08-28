package org.police.report.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.police.report.entities.File;
import org.police.report.model.FileUploadView;

@Mapper(componentModel = "spring")
public interface FileMapper {

    @Mapping(target = "file", source = "file", ignore = true)
    FileUploadView fromFileToFileView(File file);
}
