package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.StudentDao;
import com.example.util.Util;
import com.model.Student;

public class StudentDaoImpl implements StudentDao {
	
	private Connection conn;

	public StudentDaoImpl() {
		conn = Util.getConnection();
	}
	
	@Override
	public List<Student> getAllStudents(){
		List<Student> students = new ArrayList<Student>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from student" );
			while( resultSet.next() ) {
				Student student = new Student();
				student.setStudentId( resultSet.getInt( "studentId" ) );
				student.setFirstName( resultSet.getString( "firstName" ) );
				student.setLastName( resultSet.getString( "lastName" ) );
				student.setCourse( resultSet.getString( "course" ) );
				student.setYear( resultSet.getInt( "year" ) );
				students.add(student);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public void addStudent(Student student) {
		try {
			 PreparedStatement preparedStatement = conn.prepareStatement("insert into student(firstname,lastname,course,year) values (?, ?, ?, ? )");
	            // Parameters start with 1
	            preparedStatement.setString(1, student.getFirstName());
	            preparedStatement.setString(2, student.getLastName());
	            preparedStatement.setString(3, student.getCourse());
	            preparedStatement.setInt(4, student.getYear());
	            preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
