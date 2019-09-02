package com.springdemo.mvc.bean;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLang;
	private String[] operatingSystems;
	
	private LinkedHashMap<String, String> countryList;
	private LinkedHashMap<String, String> favoriteLanguageList;
	
	public Student() {
		
		 countryList = new LinkedHashMap<String, String>(); 
		 countryList.put("as", "Australia");
		 countryList.put("br", "Brazil");
		 countryList.put("de", "Germany");
		 countryList.put("in", "India");
		 countryList.put("pk", "Pakistan");
		 countryList.put("us", "United States");
		 
         favoriteLanguageList = new LinkedHashMap<>();
         favoriteLanguageList.put("Java", "Java");
         favoriteLanguageList.put("C#", "C#");
         favoriteLanguageList.put("PHP", "PHP");
         favoriteLanguageList.put("Ruby", "Ruby"); 
		 
	}
	public String[] getOperatingSystems() {
		return operatingSystems;
	}
	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LinkedHashMap<String, String> getCountryList() {
		return countryList;
	}
	public String getFavoriteLang() {
		return favoriteLang;
	}
	public void setFavoriteLang(String favoriteLang) {
		this.favoriteLang = favoriteLang;
	}
	public LinkedHashMap<String, String> getFavoriteLanguageList() {
		return favoriteLanguageList;
	}	
}
