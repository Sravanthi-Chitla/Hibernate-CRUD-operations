package com.hibernate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	private int s_id;
	private String s_name;
	private int s_marks;
	
	
	public int getS_id() {
		return s_id;
	}
	 
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	
	@Override
	public String toString() {
		return "Student [s_id=" + s_id + ", s_name=" + s_name + ", s_marks=" + s_marks + "]";
	}

	public String getS_name() {
		return s_name;
	}
	
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	
	public int getS_marks() {
		return s_marks;
	}
	
	public void setS_marks(int s_marks) {
		this.s_marks = s_marks;
	}
	
	
}
