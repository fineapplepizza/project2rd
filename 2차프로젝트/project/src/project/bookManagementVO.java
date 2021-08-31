package project;

import java.sql.Date;
import java.time.LocalDateTime;

public class bookManagementVO {
	//도서제목,저자,출판사를 관리할 수 있는 클래스
	String name;
	String author;
	String publisher;
	String image;
	String story;
	String book_name;
	Date book_date;
	Date book_return_date;
	static String id;
	int borrow_book;
	private String number;
	private String address;
	private String delivery_date;
	private String count;
	static String book_borrow_name;
	static String book_remain;
	



	public final String getNumber() {
		return number;
	}

	public final void setNumber(String number) {
		this.number = number;
	}

	public final String getAddress() {
		return address;
	}

	public final void setAddress(String address) {
		this.address = address;
	}

	public final String getDelivery_date() {
		return delivery_date;
	}

	public final void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}

	public static final String getBook_remain() {
		return book_remain;
	}

	public static final void setBook_remain(String book_remain) {
		bookManagementVO.book_remain = book_remain;
	}

	public static final String getBook_borrow_name() {
		return book_borrow_name;
	}

	public static final void setBook_borrow_name(String book_borrow_name) {
		bookManagementVO.book_borrow_name = book_borrow_name;
	}

	public static final void setId(String id) {
		bookManagementVO.id = id;
	}

	public bookManagementVO(String id) {
		this.id = id;
}

	//도서조회 생성자 메소드 생성
	public bookManagementVO(String name,String author, String publisher, String story, int borrow_book) {
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.story = story;
		this.borrow_book = borrow_book;
	}
	
	public bookManagementVO(String name,String author, String publisher,String image, String story, int borrow_book) {
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.image = image;
		this.story = story;
		this.borrow_book = borrow_book;
	}
	
	
	
	

	public bookManagementVO(String id, String book_name, Date book_date, Date book_return_date) {

		this.id = id;
		this.book_name  = book_name;
		this.book_date = book_date;
		this.book_return_date = book_return_date;
	}

	public bookManagementVO(String book_name, Date book_date, Date book_return_date) {
		this.book_name = book_name;
		this.book_date = book_date;
		this.book_return_date = book_return_date;
	}

	public bookManagementVO() {
		// TODO Auto-generated constructor stub
	}


	public bookManagementVO(String id, String book_name, String number, String address, String delivery_date) {
		this.id = id;
		this.book_name =book_name;
		this.number= number;
		this.address = address;
		this.delivery_date = delivery_date;
	}

	

	public bookManagementVO(String id, String count) {
		this.id = id;
		this.count = count;
	}

	public final String getBook_name() {
		return book_name;
	}

	public final void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public final Date getBook_date() {
		return book_date;
	}

	public final void setBook_date(Date book_date) {
		this.book_date = book_date;
	}

	public final Date getBook_return_date() {
		return book_return_date;
	}

	public final void setBook_return_date(Date book_return_date) {
		this.book_return_date = book_return_date;
	}

	public final String getId() {
		return id;
	}


	public  int getBorrow_book() {
	

		return borrow_book;
	}

	public  String getImage() {
		return image;
	}

	public  void setImage(String image) {
		this.image = image;
	}

	public  void setBorrow_book(int borrow_book) {
		this.borrow_book = borrow_book;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}
	
	public final String getCount() {
		return count;
	}

	public final void setCount(String count) {
		this.count = count;
	}



	

}
