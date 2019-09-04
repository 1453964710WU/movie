package com.wudan.main;

public class Movie {

	private Integer id;
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String name;
	private String director;
	private String area;
	private String decade;
	private String category;
	private String actor;
	private String imgsrc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Movie(Integer id, String name, String director, String area, String decade, String category, String actor,
			String imgsrc) {
		super();
		this.id = id;
		this.name = name;
		this.director = director;
		this.area = area;
		this.decade = decade;
		this.category = category;
		this.actor = actor;
		this.imgsrc = imgsrc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDecade() {
		return decade;
	}

	public void setDecade(String decade) {
		this.decade = decade;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Movie[id=" + id + ",name=" + name + ",director=" + director + ",area=" + area + ",decade=" + decade
				+ ",category=" + category + ",actor=" + actor + ",imgsrc=" + imgsrc + "]";
	}

}
