package chapter05;

// 사칙연산 클래스
// : 두 개의 값을 매개변수로 받아 사칙연산 수행
class MyMath {
	int add(int a, int b) {
		return a + b;
	}
	int sub(int a, int b) {
		return a - b;
	}
	int mul(int a, int b) {
		return a * b;
	}
	int div(int a, int b) {
		// 메서드의 조건부 반환
		if (b == 0) {
			System.out.println("정수 0으로 나눌 수 없습니다.");
			return b;
		} else {
		return a / b;
		}
	}
	
	int max(int a, int b) {
		// 
		if (a > b) return a;
		else return b;
	}
	
	int min(int a, int b) {
		return a > b ? b : a;
	}
}
public class C_Method {
	public static void main(String[] args) {
		MyMath mM = new MyMath();
		System.out.println(mM.add(10, 0));
		System.out.println(mM.sub(10, 0));
		System.out.println(mM.mul(10, 0));
//		System.out.println(mM.div(10, 0)); //java.lang.ArithmeticException
										  // >> 자바에서는 0으로 수를 나누면 예외가 발생
		// cf) 실수형 연산(0.0으로 나누기)에서는 예외가 발생하지 X
		
		System.out.println(mM.div(10, 0));
		// 정수 0으로 나눌 수 없습니다.
		
		System.out.println(mM.max(10, 20)); // 20
		System.out.println(mM.min(10, 20)); // 10
	}
}
