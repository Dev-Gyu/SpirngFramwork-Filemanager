package com.mycom.myapp.upload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myapp.upload.dao.IuploadFileRepository;
import com.mycom.myapp.upload.model.UploadFileVO;

@Service
public class UploadFileService implements IuploadFileService {
	
	@Autowired
	IuploadFileRepository uploadFileRepository;
	
	@Override
	public void uploadFile(UploadFileVO file) {
		file.setFileId(uploadFileRepository.getMaxFileId()+1);
		uploadFileRepository.uploadFile(file);
	}
	

}
