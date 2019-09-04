package com.wudan.Spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

public class spider02 {
	
	@Test
	public void test01() {
		String url = "http://www.ixinshijue.com/v/45177.html";
		try {
			Document document = Jsoup.connect(url).get();
//			System.out.println(document);
			Element e = document.selectFirst("div.pic > img");
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
