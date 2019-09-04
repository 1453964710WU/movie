package com.wudan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wudan.main.Movie;
import com.wudan.main.User;

public class MovieDao {
	
	static QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
	
	public static void insert(String name,String director,String area,String decade,String category,String actor,String imgsrc) throws SQLException {
		String sql ="INSERT INTO movie(name,director,area,decade,category,actor,imgsrc) VALUES(?,?,?,?,?,?,?)";
		Object[] params = {name,director,area,decade,category,actor,imgsrc};
		int i = queryRunner.update(sql, params);
		if(i == 1) {
			System.out.println("插入成功");
		}
	}
	
	public List<Movie> queryMovie(){
		String sql = "SELECT * FROM movie WHERE id < 11;";
		List<Movie> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Movie>(Movie.class));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	//根据电影类别查询电影
	public List<Movie> queryMovieByCategory(String category){
		String sql = "SELECT * FROM movie WHERE category REGEXP ?;";
		List<Movie> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Movie>(Movie.class),category);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public static void main(String[] args) {
		new MovieDao().queryMovieByCategory("动作");
	}
	
	//通过id查找电影
	public Movie queryMovieById(String id) {
		String sql = "SELECT * FROM movie WHERE id=?";
		Movie movie = null;
		try {
			movie = queryRunner.query(sql, new BeanHandler<Movie>(Movie.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movie;
	}
	
	public static String select(String username) {
		Connection conn = null;
		PreparedStatement pst = null;
		String password = null;
		try {
			conn = C3p0Utils.getConnection();
			String sql = "select password from user where username=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				password = rs.getString(1);
//				System.out.println(password);
				break;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}
	
	public static User selectUser(String username) {
		String sql = "SELECT * FROM user WHERE username=?";
		User user = null;
		try {
			user = queryRunner.query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public static void resgiter(String username,String password) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = C3p0Utils.getConnection();
			String sql = "INSERT INTO user(username,password) VALUES(?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.executeUpdate();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<Movie> collect(String username) {
		List<Movie> movies = new ArrayList<Movie>();
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = C3p0Utils.getConnection();
			String sql = "SELECT * FROM movie,collect WHERE movie.id=collect.collect AND collect.username=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String director = rs.getString(3);
				String area = rs.getString(4);
				String decade = rs.getString(5);
				String category = rs.getString(6);
				String actor = rs.getString(7);
				String imgsrc = rs.getString(8);
				movies.add(new Movie(id, name, director, area, decade, category, actor, imgsrc));
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}
	
	public static List<Movie> searchByName(String search){
		List<Movie> list = null;
		String sql = "SELECT * FROM movie WHERE name REGEXP ?";
		try {
			list = queryRunner.query(sql, new BeanListHandler<Movie>(Movie.class),search);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
