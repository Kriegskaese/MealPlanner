package model;

import java.util.Date;

public class MealPlanEntry {

	protected Date date;
	protected String name;

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
