package com.tinymood.dom;

// 保存books.xml的数据结构
public class Book {
	private int id;
	private String name;
	private String author;
	private String year;
	private int price;
	private String language;
	
	public Book() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		
		return "{id="+id+"},name={"+name+"},author={"+author+"},year={"+year+"},price={"+price+"},language={"+language+"}";
	}
	
	
}
