package com.wudan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class InsertData {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/book";
	
	static final String USER = "root";
	static final String PASS = "root";
	
	static {
		//1.加载驱动
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert(String book,String price,String author) {
		
		Connection conn = null;
		
		PreparedStatement pst = null;
		
		try {
			//打开连接
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			String sql = "INSERT INTO books(bname,bprice,bauthor) VALUES(?,?,?)";
			
			//预处理
			pst = conn.prepareStatement(sql);
			pst.setString(1, book);
			pst.setString(2, price);
			pst.setString(3, author);
			
			//执行
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            if(conn!=null){
                try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
	}
	
	public static void insertmodel(DefaultTableModel tm) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			String sql = "SELECT * FROM books";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name = rs.getString(2);
				String price = rs.getString(3);
				String author = rs.getString(4);
				Object[] rowData = {name,price,author};
				tm.addRow(rowData);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
