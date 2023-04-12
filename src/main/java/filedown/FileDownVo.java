package filedown;

import java.sql.Date;

public class FileDownVo {
	private int num;
	private String writer;
	private Date date;
	private String title;
	private String content;
	private String fname;
	private int cnt;
	public FileDownVo(int num, String writer, Date date, String title, String content, String fname, int cnt) {
		super();
		this.num = num;
		this.writer = writer;
		this.date = date;
		this.title = title;
		this.content = content;
		this.fname = fname;
		this.cnt = cnt;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "FileDownVo [num=" + num + ", writer=" + writer + ", date=" + date + ", title=" + title + ", content="
				+ content + ", fname=" + fname + ", cnt=" + cnt + "]";
	}
	
	
}
