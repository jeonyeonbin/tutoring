package se.hs.ac.vo;

import java.time.LocalDateTime;

import se.hs.ac.util.WorkConstants;

public class Work {
	private int id;
	private String date;
	private String contents;
	private WorkType workType;

	public Work(int id, String contents) {
		this.id = id;
		this.contents = contents;
		this.date = WorkConstants.YYYYMMDDHHMMSS.format(LocalDateTime.now());
		this.workType = WorkType.TODO;
	}

	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getContents() {
		return contents;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}

	public WorkType getWorkType() {
		return workType;
	}

	@Override
	public String toString(){
		return this.id + "\t" + this.date + "\t" + this.contents;
	}
}
