package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public abstract class Food extends Observable {
	
	protected List<FoodProperty> properties = new ArrayList<FoodProperty>();
	
	protected String name;
	protected Rating rating;
	protected int portionSize;
	protected int priceInCentsPer100;
	protected int energyPer100;
	protected int proteinPer100;
	protected int fatPer100;
	protected int carbsPer100;
	protected int id;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers();
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
		setChanged();
		notifyObservers();
	}

	public int getPortionSize() {
		return portionSize;
	}

	public void setPortionSize(int portionSize) {
		this.portionSize = portionSize;
		setChanged();
		notifyObservers();
	}

	public int getPriceInCentsPer100() {
		return priceInCentsPer100;
	}

	public void setPriceInCentsPer100(int priceInCentsPer100) {
		this.priceInCentsPer100 = priceInCentsPer100;
		setChanged();
		notifyObservers();
	}

	public int getEnergyPer100() {
		return energyPer100;
	}

	public void setEnergyPer100(int energyPer100) {
		this.energyPer100 = energyPer100;
		setChanged();
		notifyObservers();
	}

	public int getProteinPer100() {
		return proteinPer100;
	}

	public void setProteinPer100(int proteinPer100) {
		this.proteinPer100 = proteinPer100;
		setChanged();
		notifyObservers();
	}

	public int getFatPer100() {
		return fatPer100;
	}

	public void setFatPer100(int fatPer100) {
		this.fatPer100 = fatPer100;
		setChanged();
		notifyObservers();
	}

	public int getCarbsPer100() {
		return carbsPer100;
	}

	public void setCarbsPer100(int carbsPer100) {
		this.carbsPer100 = carbsPer100;
		setChanged();
		notifyObservers();
	}

}
