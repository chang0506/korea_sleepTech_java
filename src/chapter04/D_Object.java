package chapter04;

// 클래스 Book
class Book {
	// 클래스 내부의 데이터(속성, 필드)
	String title; // 제목
	String publisher; // 출판사
	int pageNumber; // 책 페이지 수
	
	// 클래스 내부의 동장(행동, 메서드)
	void displayInfo() {
		System.out.println(title + " " + publisher);
		return;
		// System.out.println("실행 안됨"); // 해당 코드에 접근할 수 X
	}
	
	// == 생성자 메서드 == //
	// : new 연산자 사용 시 호출 될 메서드
	// : 필드값 초기화에 주로 사용
	// >> 생략 시 속성에 기본값이 할당
	// cf) 기본타입 : int(0), boolean(false), char(')
	//     참조타입: null	
	
	// +) 사용자 정의 생성자 메서드 생략 시
	// >> 클래스명과 동일하면서 '매개변수'가 없는 메서드가 생략
	Book () {}
	
	Book(String title, String publisher, int pageNumber) {
		this.title = title;
		this.publisher = publisher;
		this.pageNumber = pageNumber;
	}
}

public class D_Object {
	public static void main(String[] args) {
		Book myBook = new Book();
		System.out.println(myBook.title);
		System.out.println(myBook.publisher);
		System.out.println(myBook.pageNumber);
		
		Book anoBook = new Book("백설", "코리아출판", 50);
		Book anoBook1 = new Book("신데", "에이원출판", 30);
		
		System.out.println(anoBook.title);
		System.out.println(anoBook1.title);
		
		myBook.displayInfo();
		anoBook.displayInfo();
		
		myBook.title = "개구리왕자";
		myBook.publisher = "개굴출판사";
		myBook.pageNumber = 100;
		
		myBook.displayInfo();
		
		anoBook.title = "콩쥐";
		anoBook.displayInfo();
		
		
		
		
		
		
		
		
		
		
		
	}
}
