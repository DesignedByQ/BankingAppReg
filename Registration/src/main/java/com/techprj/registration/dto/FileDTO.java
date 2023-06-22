package com.techprj.registration.dto;

import java.util.Arrays;

public class FileDTO {
	
	private String fileId;
	private String fileName;
	private String fileType;
	private byte[] fileData;
	
	public FileDTO() {
		super();
	}

	public FileDTO(String fileId, String fileName, String fileType, byte[] fileData) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileData = fileData;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "FileDTO [fileId=" + fileId + ", fileName=" + fileName + ", fileType=" + fileType + ", fileData="
				+ Arrays.toString(fileData) + "]";
	}
	
}
