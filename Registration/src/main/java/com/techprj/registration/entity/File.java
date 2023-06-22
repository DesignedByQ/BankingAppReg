package com.techprj.registration.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="files")
public class File {
	
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String fileId;
	private String fileName;
	private String fileType;
	@Lob
	private byte[] fileData;
	@OneToOne(mappedBy = "file")
	private RegDetails regDetails;
	
	public File() {
		super();
	}

	public File(String fileId, String fileName, String fileType, byte[] fileData) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileData = fileData;
	}

	public String getFileid() {
		return fileId;
	}

	public void setFileid(String fileId) {
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
		return "File [fileId=" + fileId + ", fileName=" + fileName + ", fileType=" + fileType + ", fileData="
				+ Arrays.toString(fileData) + "]";
	}

}
