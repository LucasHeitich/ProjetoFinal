package com.betha.beans;

import java.util.Calendar;

public class LayoutBean {

	private Calendar c = Calendar.getInstance();
	private String data;
	

	
	public Calendar getC() {
		return c;
	}

	public void setC(Calendar c) {
		this.c = c;
	}

	public String getData() {
		this.data = Integer.toString((c.get(Calendar.YEAR)));
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
