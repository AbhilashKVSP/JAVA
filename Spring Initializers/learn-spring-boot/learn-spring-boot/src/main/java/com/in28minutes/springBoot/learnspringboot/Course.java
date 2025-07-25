package com.in28minutes.springBoot.learnspringboot;

public class Course {
	
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	private long id;
	private String name;
	private String author;

	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getAuthor() {
		return author;
	}
	
	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + ", author=" + author + ", toString()=" + super.toString() + "]";
	}
		

}
