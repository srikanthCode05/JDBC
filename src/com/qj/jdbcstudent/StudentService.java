package com.qj.jdbcstudent;

import java.sql.SQLException;

public class StudentService 
{
	StudentDao dao=new StudentDao();
	public double percentage(StudentDto student)
	{
		double result=student.getEnglish()+student.getMaths()+student.getScience();
		return (result/300)*100;
	}
	
	public double totalResult(StudentDto student)
	{
		return student.getEnglish()+student.getMaths()+student.getScience();
	}
	
	public String grade(double percentage)
	{
		if(percentage>=90)
		{
			return "O";
		}
		else if(percentage>=80 && percentage<90)
		{
			return "A+";
		}
		else if(percentage>=70 && percentage<80)
		{
			return "A";
		}
		else if(percentage>=60 && percentage<70)
		{
			return "B+";
		}
		else if(percentage>=50 && percentage<60)
		{
			return "B";
		}
		else if(percentage>=35 && percentage<50)
		{
			return "C";
		}
		else
		{
			return "Fail";
		}
	}
	public void saveStudent(StudentDto student) throws SQLException
	{
		double result=totalResult(student);
		double percentage=percentage(student);
		String grade=grade(percentage);
		StudentDto newStudent=student;
		newStudent.setResult(result);
		newStudent.setPercentage(percentage);
		newStudent.setGrade(grade);
//		student.setResult(result);
//		student.setPercentage(percentage);
//		student.setGrade(grade);
		StudentDao dao=new StudentDao();
		dao.saveStudent(newStudent);
		
	}
	public void updateStudent(int id,StudentDto student) throws SQLException
	{
		double result=totalResult(student);
		double percentage=percentage(student);
		String grade=grade(percentage);
		StudentDto newStudent=student;
		newStudent.setResult(result);
		newStudent.setPercentage(percentage);
		newStudent.setGrade(grade);
//		student.setResult(result);
//		student.setPercentage(percentage);
//		student.setGrade(grade);
		StudentDao dao=new StudentDao();
		dao.updateStudent(id,student);
	}
	public StudentDto getStudentById(int id) throws SQLException
	{
		return dao.getStudentById(id);
	}
}
