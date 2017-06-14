package model;

import java.util.Observable;

public class FoodProperty extends Observable {

	private String name;
	private Object value;
	private boolean useManualValue = true;

	public FoodProperty(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public FoodProperty(String name, Object value, boolean useManualValue) {
		this.name = name;
		this.value = value;
		this.useManualValue = useManualValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers();
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
		setChanged();
		notifyObservers();
	}

	public boolean usesManualValue() {
		return useManualValue;
	}

	public void setUseManualValue(boolean useManualValue) {
		this.useManualValue = useManualValue;
		setChanged();
		notifyObservers();
	}

}
