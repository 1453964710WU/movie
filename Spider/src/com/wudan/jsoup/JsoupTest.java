package com.wudan.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class JsoupTest {
	@Test
	public void test01() {
		
		String html =  "<html><head><title>First parse</title></head>"
				  + "<body><p>Parsed HTML into a doc.</p></body></html>";
		
		Document document = Jsoup.parse(html);
		System.out.println(document);
		
	}
	
	@Test
	public void test02() {
		try {
			Document doc = Jsoup.connect("http://www.baidu.com").timeout(3000).get();
//			System.out.println(doc);
//			String title = doc.title();
//			System.out.println(title);
			
//			Elements elements = doc.getElementsByTag("a");
//			for (Element element : elements) {
//				System.out.println(element);
//				//获取属性值
//				String value = element.attr("href");
//				String text = element.text();
//				System.out.println(value);
//				System.out.println(text);
//			}
			
//			//选择器
//			Elements imgs = doc.select("img[src$=.png]");
//			for (Element img : imgs) {
//				System.out.println(img);
//				String src = img.attr("src");
//				System.out.println(src);
//			}
			
//			Elements elements = doc.select("a.mnav");
//			for (Element element : elements) {
//				System.out.println(element);
//			}
			
//			Element element = doc.selectFirst("a.mnav");
//			System.out.println(element);
			
			Elements elements = doc.select("div#u1 > a");
			for (Element element : elements) {
				System.out.println(element);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
