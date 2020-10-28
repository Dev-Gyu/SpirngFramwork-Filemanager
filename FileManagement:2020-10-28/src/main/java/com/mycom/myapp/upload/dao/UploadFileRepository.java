package com.mycom.myapp.upload.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mycom.myapp.upload.model.UploadFileVO;



@Repository
public class UploadFileRepository implements IuploadFileRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int getMaxFileId() {
		String sql = "SELECT NVL(MAX(FILE_ID),0) FROM UPLOAD_FILE";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	@Override
	public void uploadFile(UploadFileVO file) {
		String sql = "INSERT INTO UPLOAD_FILE "
				+ "(FILE_ID, DIRECTORY_NAME, FILE_NAME, FILE_SIZE, "
				+ "FILE_CONTENTTYPE, FILE_UPLOAD_DATE, FILE_DATA) "
				+ "VALUES (?, ?, ?, ?, ?, SYSDATE, ?)";
		jdbcTemplate.update(sql,
				file.getFileId(),
				file.getDirectoryName(),
				file.getFileName(),
				file.getFileContentType(),
				file.getFileData());
	}

}
