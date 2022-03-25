package kr.or.ddit.basic.fileupload;

// 파일 정보가 저장될 VO객체
public class FileInfoVO {
	private String fileName; // 파일이름
	private long fileSize; // 파일크기
	private String uploadStatus; // Upload 성공여부
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
}