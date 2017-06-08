package model;

import java.util.List;

public abstract class Category {

	private String name;
	private List<Food> members;
	
	public Category(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addMember(Food food) {
		members.add(food);
	}

}
