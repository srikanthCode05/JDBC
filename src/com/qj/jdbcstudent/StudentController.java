package com.qj.jdbcstudent;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentController 
{
	public static void main(String[] args) throws SQLException 
	{
		
//		StudentDto dto=new StudentDto();
//		dto.setId(2);
//		dto.setName("ramesh");
//		dto.setEnglish(85);
//		dto.setMaths(65);
//		dto.setScience(76);
		
		StudentDao dao=new StudentDao();
//		StudentService service=new StudentService();
		System.out.println(dao.getStudentById(1));

		
		
//		StudentService service=new StudentService();
//		StudentDto sdto=service.getStudentById(2);
//		
//		if(sdto!=null) {
//			sdto.setName("vignesh");
//			sdto.setEnglish(75);
//			sdto.setMaths(74);
//			sdto.setScience(65);
//		}else {
//			System.out.println("is null");
//		}
//		
//		service.updateStudent(2, sdto);


	
		

		
	
//		StudentDao dao=new StudentDao();
//		ArrayList<StudentDto> students=dao.getAllStudents();
//		System.out.println(students);
		
		
	}
}
