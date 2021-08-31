package model;

public class centerDTO {
	private String c_Do;
	private String c_SiGoon;
	private String c_Name;
	private String c_Tel;
	private String c_Addr;
	public String getC_Do() {
		return c_Do;
	}
	public void setC_Do(String c_Do) {
		this.c_Do = c_Do;
	}
	public String getC_SiGoon() {
		return c_SiGoon;
	}
	public void setC_SiGoon(String c_SiGoon) {
		this.c_SiGoon = c_SiGoon;
	}
	public String getC_Name() {
		return c_Name;
	}
	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}
	public String getC_Tel() {
		return c_Tel;
	}
	public void setC_Tel(String c_Tel) {
		this.c_Tel = c_Tel;
	}
	public String getC_Addr() {
		return c_Addr;
	}
	public void setC_Addr(String c_Addr) {
		this.c_Addr = c_Addr;
	}
	public centerDTO(String c_Do, String c_SiGoon, String c_Name, String c_Tel, String c_Addr) {
		super();
		this.c_Do = c_Do;
		this.c_SiGoon = c_SiGoon;
		this.c_Name = c_Name;
		this.c_Tel = c_Tel;
		this.c_Addr = c_Addr;
	}
	
	
	
	
}