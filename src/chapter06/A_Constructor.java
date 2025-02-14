package chapter06;

// == 생성자(Counstructor) == //
// : 객체(인스턴스)가 생성될 호출되는 '인스턴스 초기화 메서드'

// - 생성자 조건
//		: 클래스명과 동일한 이름을 사용
//		: 리턴값이 없는 메서드 형식 (void 타입이 생략)

// '컴파일러가 제공하는 기본 생성자'
// : 클래스에 생성자가 없으면 자동 생성되는 빈 생성자
// >> 매개변수 X, 아무런 작업도 하지 X(구현부 내의 코드 X)

class Example1 {
	int value;
	// 기본 생성자 생략
}

class Example2 {
	int value;
	
	// 사용자 정의 생성자
	// : 컴파일러가 자동으로 기본 생성자를 제거
	Example2(int value) {
		this.value = value;
	}
	
	// 빈 생성자의 경우 직접적인 명시도 가능
//	Example2() {}
}

class Car {
	String color;
	String gearType; // auto(자동), manual(수동)
	int door;
	
	Car() {} // 기본 생성자 정의 - 차를 생성한 뒤 필드값 초기화
	
	// 사용자 정의 생성자
	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	Car(String color) {
		// cf) 사용자 정의 생성자에서 다른 생성자 호출 this()
		//		: 생성자 이름으로 클래스명 대신 this를 사용한다
		//		>> 정의 생성자에서 타 생성자 호출 시 반드시!! 첫 줄에서만 호출 가능!!
		
		// - 호출 된 생성자가 변수값을 초기화 하는 경우
		//		: 현재의 생성자가 수행하는 작업을 유지하기 위함 (무의미함 방지)
		
		this(color, "auto", 4);
		
		
	}
}

public class A_Constructor {
	public static void main(String[] args) {
		Example1 ex1 = new Example1(); // 빈 생성자 호출 - 전달할 인자 X
		Example2 ex2 = new Example2(50);
		
		// == Car 인스턴스 생성 == //
		Car c1 = new Car(); // 기본 생성자
		
		c1.color = "black"; // 객체명.필드명
		c1.gearType = "auto";
		c1.door = 4;
		
		Car c2 = new Car("white", "manual", 2); // 사용자 정의 생성자 호출
		
		// cf) 인스턴스 생성
		//		: 생성자가 인스턴스 생성 X
		//		>> new 연산자가 인스턴스 생성 O
	}
}
