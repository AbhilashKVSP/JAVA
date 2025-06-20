package com.LibraryManagement.LMS.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "mylibrary-config")
@Component
public class LibraryConfiguration {

	private final String libraryName = "Vivekananda Library House";
	private String contactEmail;
	private int maxBooksPerMember;
	private int maxBorrowDays;
	
	public String getLibraryname() {
		return libraryName;
	}
	public String getContactemail() {
		return contactEmail;
	}
	public int getMaxbookspermember() {
		return maxBooksPerMember;
	}
	public int getMaxborrowdays() {
		return maxBorrowDays;
	}
	
	public void setContactemail(String contactemail) {
		this.contactEmail = contactemail;
	}
	public void setMaxbookspermember(int maxbookspermember) {
		this.maxBooksPerMember = maxbookspermember;
	}
	public void setMaxborrowdays(int maxborrowdays) {
		this.maxBorrowDays = maxborrowdays;
	}
	
	
	
}
