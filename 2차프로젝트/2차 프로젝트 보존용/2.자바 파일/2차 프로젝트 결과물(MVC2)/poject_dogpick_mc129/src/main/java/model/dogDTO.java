package model;

public class dogDTO {
	
	private String dogName;
	private String size;
	private String weight;
	private String sick;
	private String chr;
	
	
	public dogDTO(String dogName, String size, String weight, String sick, String chr) {
		super();
		this.dogName = dogName;
		this.size = size;
		this.weight = weight;
		this.sick = sick;
		this.chr = chr;
	}


	public String getDogName() {
		return dogName;
	}


	public void setDogName(String dogName) {
		this.dogName = dogName;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}



	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getSick() {
		return sick;
	}


	public void setSick(String sick) {
		this.sick = sick;
	}


	public String getChr() {
		return chr;
	}


	public void setChr(String chr) {
		this.chr = chr;
	}
	
	
	

}
