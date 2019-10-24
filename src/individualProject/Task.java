package individualProject;

import java.io.Serializable;

import java.text.DateFormat;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Serializable {
	
	private String title;
	private Date dueDate;
	private Boolean markAsDone;
	
	public Task (String title, String dueDate, Boolean markAsDone) {
		this.setTitle(title);
		this.setDueDate(dueDate);
		this.setMarkAsDone(markAsDone);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if(title == null)
			throw new IllegalArgumentException();
		this.title = title;
	}

	public String getDueDate() {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = formatter.format(dueDate); 
		return strDate;
	}

	public void setDueDate(String dueDate)  {
		if(dueDate == null)
			throw new IllegalArgumentException();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");	
		try {
			this.dueDate  = format.parse(dueDate);
		} 
		catch (ParseException e) {
			throw new IllegalArgumentException();
		}
	}

	public Boolean getMarkAsDone() {
		return markAsDone;
	}

	public void setMarkAsDone(Boolean markAsDone) {
		if(markAsDone == null)
			throw new IllegalArgumentException();
		this.markAsDone = markAsDone;
	}
	
	// Task status	
	public String status () {
		String status = null;
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.format(date);
		if(this.getMarkAsDone()) {
			status = "done";
		}
		else {
	     if (date.compareTo(this.dueDate) > 0) {
	    	 status = "late";
	        } else if (date.compareTo(this.dueDate) < 0) {
	        	 status = "wait";
	        } else if (date.compareTo(this.dueDate) == 0) {
	        	 status = "now";
	        } 
	     }
	     return status ;
	}
}