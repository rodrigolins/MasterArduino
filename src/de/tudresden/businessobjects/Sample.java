package de.tudresden.businessobjects;

import java.util.List;

public class Sample {
	private Integer id;
	private String type;
	private String model;
	private List<Property> properties;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	@Override
	public String toString() {
		return "Sample [id=" + id + ", type=" + type + ", model=" + model + ", properties=" + properties + "]";
	}
}


