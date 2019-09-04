package com.wudan.Spider;

import java.io.IOException;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.wudan.Dao.MovieDao;

public class spider01 {
	
	@Test
	public void test01() {
		String URL = "http://v.hao123.baidu.com/v/search?channel=movie";
		
		try {
			for (int i = 1; i < 101; i++) {
				String list = "&pn=" + i;
				String url = URL + list;
				Document document = Jsoup.connect(url).timeout(5000).get();
//				System.out.println(document);
				Elements elements = document.select("ul.wg-c-list").select(".clearfix > li > a");
				for (Element element : elements) {
//					System.out.println(element);
					String href = element.attr("href");
					String name = element.attr("title");
					String imgsrc = element.select("div.inner > img").attr("src");
					Document doc = Jsoup.connect(href).timeout(5000).get();
					String director = doc.select("div.info > p > span[monkey=\"director\"] > a").text();
//					System.out.println(director);
					String area = doc.select("div.info > p > span[monkey=\"area\"] > a").text();
//					System.out.println(area);
					String decade = doc.select("div.info > p > span[monkey=\"decade\"] > a").text();
//					System.out.println(decade);
					String category = doc.select("div.info > p > span[monkey=\"category\"] > a").text();
//					System.out.println(category);
					String actor = doc.select("div.info > p > span[monkey=\"actor\"] > a").text();
//					System.out.println(actor);
					//≤Â»Î ˝æ›ø‚
					try {
						MovieDao.insert(name, director, area, decade, category, actor, imgsrc);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
