package de.tudresden.businessobjects;

public class Property {
	private String name;
	private Double value;
	private String unit;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		return "Property [name=" + name + ", value=" + value + ", unit=" + unit + "]";
	}
}
