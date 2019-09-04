package com.wudan.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JsoupTest02 {
	
	@Test
	public void test01() {
		try {
			Document doc = Jsoup.connect("http://book.dangdang.com").get();
//			System.out.println(doc);
			Elements elements = doc.select("ul.product_ul > li");
			for (Element element : elements) {
				String name = element.select("p.name > a").text();
				String author = element.select("p.author").text();
				Elements eles = element.select("p.price > span");
				String price = null;
				for (Element e : eles) {
					price += e.text();
				}
				System.out.println(name + "  " + author + "  " + price);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test02() {
		try {
			Document doc = Jsoup.connect("http://search.dangdang.com/?key=python&act=input").get();
//			System.out.println(doc);
			Elements elements = doc.select("ul.bigimg > li");
			for (Element element : elements) {
				String name = element.select("p.name > a").attr("title");
				String price = element.select("p.price > span.search_now_price").text();
				price = price.replace("?", "");
				String author = element.select("p.search_book_author > span > a").attr("title");
				System.out.println(name + " " + price + " " + author);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
