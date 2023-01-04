package com.qj.jdbcstudent;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentDao 
{
	String url="jdbc:mysql://localhost:3306/school_project";
	String user="root";
	String pwd="SQLdeveloper@05";
	static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	public Connection getConnection() throws SQLException
	{
//		Connection con=DriverManager.getConnection(url,user,pwd);
		return DriverManager.getConnection(url,user,pwd);
	}
	
	public void saveStudent(StudentDto student) throws SQLException
	{
		Connection con=getConnection();
		String sql="{call saveStudent(?,?,?,?,?,?,?,?)}";
		CallableStatement call=con.prepareCall(sql);
        call.setInt(1,student.getId());
        call.setString(2, student.getName());
        call.setDouble(3, student.getEnglish());
        call.setDouble(4, student.getMaths());
        call.setDouble(5, student.getScience());
        call.setDouble(6, student.getResult());
        call.setDouble(7, student.getPercentage());
        call.setString(8,student.getGrade());
        int i=call.executeUpdate();
        if(i>0)
        {
        	System.out.println("The student details with Id "+student.getId()+" is saved successfully");
        	
        }
    }
	
	public void deleteAllStudents() throws SQLException
	{
		Connection con=getConnection();
		String sql="{call deleteAllStudents()}";
		CallableStatement call=con.prepareCall(sql);
		int i=call.executeUpdate();
		if(i>0)
		{
			System.out.println("All the data is deleted");
		}
		else
		{
			System.out.println("No data is to be deleted");
		}
	}
	
	public ArrayList<StudentDto> getAllStudents() throws SQLException
	{
		ArrayList<StudentDto> students=new ArrayList<StudentDto>();
		Connection con=getConnection();
		String sql="{call getAllStudents()}";
		CallableStatement call=con.prepareCall(sql);
		ResultSet resultSet=call.executeQuery();
		while(resultSet.next())
		{
			StudentDto student=new StudentDto();
			student.setId(resultSet.getInt(1));
			student.setName(resultSet.getString(2));
			student.setEnglish(resultSet.getDouble(3));
			student.setMaths(resultSet.getDouble(4));
			student.setScience(resultSet.getDouble(5));
			student.setResult(resultSet.getDouble(6));
			student.setPercentage(resultSet.getDouble(7));
			student.setGrade(resultSet.getString(8));
			students.add(student);			
		}
		return students;
	}
	
	public void updateStudent(int id,StudentDto student) throws SQLException
	{

		Connection con=getConnection();
		String sql="{call updateStudent(?,?,?,?,?,?,?,?)}";
		CallableStatement call=con.prepareCall(sql);
		
		call.setInt(1, student.getId());
        call.setString(2, student.getName());
        call.setDouble(3, student.getEnglish());
        call.setDouble(4, student.getMaths());
        call.setDouble(5, student.getScience());
        call.setDouble(6, student.getResult());
        call.setDouble(7, student.getPercentage());
        call.setString(8, student.getGrade());
        
		int i=call.executeUpdate();
		if(i>0)
		{
			System.out.println("the student with id "+student.getId()+" is updated successfully");
		}
		else
		{
			System.out.println("student is not updated");
		}
	}
	
	public StudentDto getStudentById(int id) throws SQLException
	{
		Connection con=getConnection();
		String sql="{call getStudentById(?)}";
		CallableStatement call=con.prepareCall(sql);
		call.setInt(1, id);
		ResultSet resultSet=call.executeQuery();
		if(resultSet.next())
		{
			StudentDto student=new StudentDto();
			student.setId(resultSet.getInt(1));
			student.setName(resultSet.getString(2));
			student.setEnglish(resultSet.getDouble(3));
			student.setMaths(resultSet.getDouble(4));
			student.setScience(resultSet.getDouble(5));
			student.setResult(resultSet.getDouble(6));
			student.setPercentage(resultSet.getDouble(7));
			student.setGrade(resultSet.getString(8));
			return student;			
		}
		else
		{
			return null;
		}
	}
	public boolean deleteStudentById(int id) throws SQLException
	{
		
		Connection con=getConnection();
		String sql="{call deleteStudentById(?)}";
		CallableStatement call=con.prepareCall(sql);
		call.setInt(1,id);
		int i=call.executeUpdate();
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
