package com.nt.dto;

import java.io.Serializable;

public class Customerdto implements Serializable{
	
	private String name;
	private String add;
	private float amt;
	private float intrest;
	private float months;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public float getAmt() {
		return amt;
	}
	public void setAmt(float amt) {
		this.amt = amt;
	}
	public float getIntrest() {
		return intrest;
	}
	public void setIntrest(float intrest) {
		this.intrest = intrest;
	}
	public float getMonths() {
		return months;
	}
	public void setMonths(float months) {
		this.months = months;
	}

}
