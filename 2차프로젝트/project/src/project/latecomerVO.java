package project;

public class latecomerVO {
	
	private String id;
    private String name;
    private String bookRental;
    private String bookreturn;
    private String returnStatus;

    


	public latecomerVO(String id, String name, String bookRental, String bookreturn, String returnStatus) {
    	this.id = id;
    	this.name = name;
    	this.bookRental = bookRental;
    	this.bookreturn = bookreturn;
    	this.returnStatus = returnStatus;
    }

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getBookRental() {
		return bookRental;
	}

	public void setBookRental(String bookRental) {
		this.bookRental = bookRental;
	}

	public String getBookreturn() {
		return bookreturn;
	}

	public void setBookreturn(String bookreturn) {
		this.bookreturn = bookreturn;
	}
    
}
