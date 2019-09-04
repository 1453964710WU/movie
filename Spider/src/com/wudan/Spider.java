package com.wudan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Spider {
	
	public static void start(String urlstr) {
		URL url = null;
		HttpURLConnection conn = null;
		BufferedReader br = null;
		try {
			//拿到路径
			url = new URL(urlstr);
			//拿到连接
			conn = (HttpURLConnection)url.openConnection();
			//连接
			conn.connect();
			
			//拿到输入流
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String data = null;
			boolean flag = false;
			while((data = br.readLine()) != null) {
				
				if((data.indexOf("class=\"bigimg\"")) != -1){
					flag = true;
				}
				
				if((data.indexOf("</ul>")) != -1 && flag) {
					flag = false;
					break;
				}
				
				if(flag && data.indexOf("<li") != -1 ) {
					data = br.readLine();
					
					String bookName = data.replace("<a title=\"", "");
					//System.out.println(data);
					int endBookName = bookName.indexOf("\"");
					bookName = bookName.substring(0,endBookName);
					bookName = bookName.trim();
//					System.out.println(bookName);
					
					
					int startIndex = data.indexOf("<span class=\"search_now_price\"");
					int endIndex = data.indexOf("</span>");
					String price = null;
					if(startIndex != -1) {
						price = data.substring(startIndex,endIndex);
						price = price.replace("<span class=\"search_now_price\">&yen;", "");
//						System.out.println(price);
					}
					
					
					int startAuthor = data.indexOf("key2=");
					int endAuthor = data.indexOf("&medium=01");
					String authorName = null;
					if(startAuthor != -1) {
						authorName = data.substring(startAuthor,endAuthor);
						authorName = authorName.replace("key2=", "");
						
//						System.out.println(authorName);
					}
					
					
//					System.out.println(bookName + price + authorName);
					//插入数据库
					new InsertData().insert(bookName, price, authorName);
				}
				
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
