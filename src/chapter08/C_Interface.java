package chapter08;

// 인터페이스 명명 규칙
// : 클래스와 동일 - UpperCamelCase
interface Flyable {
	int AVERAGE_SPEED = 100; // pubilc static final
	
	void fly(); // 추상 메서드 - public abstract
	
	// 해당 인터페이스를 구현하는 클래스에서 오버라이딩 가능
	default void land() {
		System.out.println("착륙합니다.");
	}
	
	// 인터페이스 호춟만 가능! - 재정의 불가능
	static int getWingCount() {
		return 2;
	}
}

class 참새 implements Flyable {
	public void fly() {
		System.out.println("참새의 속력은 " + AVERAGE_SPEED + "km의 평균 속도보다 느립니다.");
	}
	
	@Override
	public void land() {
		System.out.println("사뿐");
	}
}

class 독수리 implements Flyable {
	public void fly() {
		System.out.println("독수리의 속력은 " + AVERAGE_SPEED + "km의 평균 속도보다 빠릅니다.");
	}
	
	@Override
	public void land() {
		System.out.println("슈우우웅");
	}
}

public class C_Interface {
	public static void main(String[] args) {
		참새 bird1 = new 참새();
		
		bird1.fly(); //참새의 속력은 100km의 평균 속도보다 느립니다.
		bird1.land(); // 사뿐
		
		독수리 bird2 = new 독수리();
		
		bird2.fly(); // 독수리의 속력은 100km의 평균 속도보다 빠릅니다.
		bird2.land(); // 슈우우웅
		
		System.out.println(Flyable.getWingCount()); // 2
	}
}
