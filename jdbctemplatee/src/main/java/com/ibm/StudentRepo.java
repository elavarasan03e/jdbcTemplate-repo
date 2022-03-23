package com.ibm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {
	
	@Autowired
	JdbcTemplate template;
	
	int getCountOfStudents() {
		 return template.queryForObject("select count(*) from students", Integer.class);
		
	}
	
	void addNewStudent(Student theStudent) {
		template.update("insert into students values (?, ?, ?)", new Object[] {theStudent.id(), theStudent.name(), theStudent.dept()});
	}
	
	void updateStudentbyId(Student student,int id) {
		template.update("update stuednts set name=? , dept=? where id=?",new Object[] {student.name(),student.dept()},id);
	}
	
	void deleteStudentById(int id) {
		template.update("delete from students where id= ?",new Object[] {id});
	}
	
	void DetailsofStudentById(int id) {
		template.queryForList("select name ,dept from students where id = ?", new Object[] {id});
	}
}
