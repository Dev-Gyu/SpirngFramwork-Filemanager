package com.mycom.myapp.upload.dao;

import com.mycom.myapp.upload.model.UploadFileVO;

public interface IuploadFileRepository {
	int getMaxFileId();
	void uploadFile(UploadFileVO file);
	
	/*List<UploadFileVO> getFileList(String directoryName);
	List<UploadFileVO> getAllFileList();
	List<UploadFileVO> getImageList(String directoryName);
	
	UploadFileVO getFile(int fileId);
	
	String getDirectoryName(int fileId);
	void updateDirectory(HashMap<String, Object> map);
	
	void deleteFile(int fileId);
	void updateFile(UploadFileVO file);
	*/

}
