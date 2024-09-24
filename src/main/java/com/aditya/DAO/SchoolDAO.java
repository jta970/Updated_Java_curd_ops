package com.aditya.DAO;

import java.awt.color.ICC_ColorSpace;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.aditya.utility.ConnectionFactory;

import entity.school;

public class SchoolDAO {
	
	private static SchoolDAO schoolDAO = null;
	
	public SchoolDAO() {
		
	}
	
	public static SchoolDAO getInstance() {
		if(schoolDAO == null) {
			schoolDAO = new SchoolDAO();
		}
		return schoolDAO;
	}
	
	public List<school> Select() {
		try {
			
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from school");
			
			
			ResultSet resultSet = ps.executeQuery();
			
			List<school> list = new ArrayList<>();
			
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                
                school school = new school(id, name, age);
                list.add(school);
            }
            
            return list;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public int Delete(int input) {
		try {
			
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("Delete from school where id = ?");
			ps.setInt(1, input);
			
			int result = ps.executeUpdate();
			return result;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int Update(int input, String name) {
		try {
			
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("Update school set name = ? where id = ?");
			ps.setInt(2, input);
			ps.setString(1, name);
			
			int result = ps.executeUpdate();
			return result;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int Insert(int input, String name, int age) {
		
		try {
			
			Connection connection = ConnectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("insert into school(id, name, age) values (?, ?, ?)");
			ps.setInt(1, input);
			ps.setString(2, name);
			ps.setInt(3, age);
			
			int result = ps.executeUpdate();
			return result;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}
