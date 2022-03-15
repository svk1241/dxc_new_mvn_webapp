package com.dxc.springcoreapp.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Country 
{
	String countryName;
	String continentName;
	//List<String> states;
	Map<String,String> states;
	
	public void Country() {}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getContinentName() {
		return continentName;
	}
	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}
	public Map<String,String> getStates() {
		return states;
	}
	public void setStates(Map<String,String> states) {
		this.states = states;
	}
	/*public List<String> getStates() {
		return states;
	}
	public void setStates(List<String> states) {
		this.states = states;*/
	}
	


