package com.mycom.myapp.upload.service;

import java.util.List;

import com.mycom.myapp.upload.model.UploadFileVO;

public interface IuploadFileService {
	
	void uploadFile(UploadFileVO file);
	
	List<UploadFileVO> getFileList(String dir);
	List<UploadFileVO> getAllFileList();
	List<UploadFileVO> getImageList(String dir);
	
	UploadFileVO getFile(int fileId);
	
	String getDirectoryName(int fileId);
	void updateDirectory(int[] fileIds, String directoryName);
	
	void deleteFile(int fileId);
	void updateFile(UploadFileVO file);

}
