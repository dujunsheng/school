package com.school.vo;

public class FileUploadVo {

	private String realPath; // 文件保存的绝对路径,不包括文件名在内
	private String relativePath; // 相对路径，包括文件名
	private String fileName; // 文件名

	public String getRealPath() {
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

}
