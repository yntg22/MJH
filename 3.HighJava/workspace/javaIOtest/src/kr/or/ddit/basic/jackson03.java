package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jackson03 {

	public static void main(String[] args) {
		

		ObjectMapper mapper = new ObjectMapper();
		
		Article article = new Article();
		
		try {
			article = mapper.readValue(new File("result.json"), Article.class);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(article);
	}
	
}

class Article{
	public int id;
	public String regDate;
	public String title;
	
	public Article(int id, String regDate, String title, String body) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", regDate=" + regDate + ", title=" + title + ", body=" + body + "]";
	}
	public Article() {
		
	}
	public String body;
	

}