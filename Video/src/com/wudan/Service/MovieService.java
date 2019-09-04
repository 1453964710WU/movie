package com.wudan.Service;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.wudan.Dao.MovieDao;
import com.wudan.main.Movie;
import com.wudan.main.User;

public class MovieService {
	
	private MovieDao movieDao = new MovieDao();
	
	//��ѯ��ͬcategory�ĵ�Ӱ
	public String queryMovieByCategory(String category) {
		List<Movie> mList = movieDao.queryMovieByCategory(category);
		return JSON.toJSONString(mList);
	}
	
	public String queryMovie() {
		List<Movie> mList = movieDao.queryMovie();
		return JSON.toJSONString(mList);
	}
	
	//����id��ѯ��Ӱ����Ϣ
	public String queryMovieById(String id) {
		Movie movie = movieDao.queryMovieById(id);
		return JSON.toJSONString(movie);
	}
	
	//�����û���������Ϣ
	public String queryUserByUsername(String username) {
		User user = MovieDao.selectUser(username);
		return JSON.toJSONString(user);
	}
	
	//�����û�������collect
	public String collect(String username) {
		List<Movie> movies = movieDao.collect(username);
		return JSON.toJSONString(movies);
	}
	
	//����search��ѯ��Ӱ
	public String searchByName(String search) {
		List<Movie> movies = movieDao.searchByName(search);
		return JSON.toJSONString(movies);
	}
	
}
