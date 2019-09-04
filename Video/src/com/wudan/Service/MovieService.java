package com.wudan.Service;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.wudan.Dao.MovieDao;
import com.wudan.main.Movie;
import com.wudan.main.User;

public class MovieService {
	
	private MovieDao movieDao = new MovieDao();
	
	//查询相同category的电影
	public String queryMovieByCategory(String category) {
		List<Movie> mList = movieDao.queryMovieByCategory(category);
		return JSON.toJSONString(mList);
	}
	
	public String queryMovie() {
		List<Movie> mList = movieDao.queryMovie();
		return JSON.toJSONString(mList);
	}
	
	//根据id查询电影的信息
	public String queryMovieById(String id) {
		Movie movie = movieDao.queryMovieById(id);
		return JSON.toJSONString(movie);
	}
	
	//根据用户名查找信息
	public String queryUserByUsername(String username) {
		User user = MovieDao.selectUser(username);
		return JSON.toJSONString(user);
	}
	
	//根据用户名查找collect
	public String collect(String username) {
		List<Movie> movies = movieDao.collect(username);
		return JSON.toJSONString(movies);
	}
	
	//根据search查询电影
	public String searchByName(String search) {
		List<Movie> movies = movieDao.searchByName(search);
		return JSON.toJSONString(movies);
	}
	
}
