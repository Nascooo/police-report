package org.police.report.repository;

import org.police.report.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    @Query("select  fileId , fileName from file")
    List<File> getUploadedFilesName();
}
