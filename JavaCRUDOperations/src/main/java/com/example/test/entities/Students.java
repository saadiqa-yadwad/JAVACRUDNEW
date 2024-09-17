package com.example.test.entities;

import jakarta.persistence.*;;

@Entity
public class Students {
	@Id 
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int Stu_id;
	private String Stu_name;
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Students(int stu_id, String stu_name, int stu_Percentage) {
		super();
		Stu_id = stu_id;
		Stu_name = stu_name;
		Stu_Percentage = stu_Percentage;
	}
	@Override
	public String toString() {
		return "Students [Stu_id=" + Stu_id + ", Stu_name=" + Stu_name + ", Stu_Percentage=" + Stu_Percentage + "]";
	}
	private int Stu_Percentage;
	public int getStu_id() {
		return Stu_id;
	}
	public void setStu_id(int stu_id) {
		Stu_id = stu_id;
	}
	public String getStu_name() {
		return Stu_name;
	}
	public void setStu_name(String stu_name) {
		Stu_name = stu_name;
	}
	public int getStu_Percentage() {
		return Stu_Percentage;
	}
	public void setStu_Percentage(int stu_Percentage) {
		Stu_Percentage = stu_Percentage;
	}
	
	
	

}
