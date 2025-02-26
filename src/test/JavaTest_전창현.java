package test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lombok.Getter;

// 5번 코드구현 문제 클래스 Student
@Getter
class Student {
	String name; // 이름
	int score; // 점수

	Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

public class JavaTest_전창현 {
	public static void main(String[] args) {
		// 1. 서술형
		// - 기본 데이터 타입:
		// 의미: 변수 선언 시 해당 자료형의 크기만큼 메모리 할당
		// 종류: byte, short, long, float, int, char, boolean, double
		// 저장되는 것: 실제 데이터 값
		// 예시: int num = 10;

		// - 참조 데이터 타입:
		// 의미: 객체의 참조를 저장하는 타입
		// 종류: String, 객체, 배열, 인터페이스, 클래스
		// 저장되는 것: 해당 객체의 메모리 주소 값
		// 예시: String name = "전창현";

		// 2. 코드 구현 문제
		int num1 = 10;
		double num2 = 3.5;
		double result = num1 + num2;
		System.out.println(result);

		// 3. 코드 구현 문제
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if (input % 2 == 0) {
			System.out.println("입력하신 숫자는 짝수입니다.");
		} else {
			System.out.println("입력하신 숫자는 홀수입니다.");
		}

		// 4. 코드 구현 문제
		int[] numbers = { 1, 2, 3, 4, 5 };
		for (int n : numbers) {
			System.out.println(n);
		}

		// 5. 코드 구현 문제 - 배열이랑 리스트를 구분할 줄 알아야하는데 이 방법밖에 생각이 안납니다 추가로 공부해야할 것 같아요
		List<Student> st = Arrays.asList(new Student("John", 85)
				, new Student("Jane", 92)
				, new Student("Tom", 78)
				, new Student("Emily", 88)
				, new Student("Alex", 95));
		for (Student student : st) {
			if (student.getScore() >= 90) {
				System.out.println(student.getName());
			}
		}

		// 6. 단답형
		// 	Object
		
		// 7. 단답형
		//	.size()
		
		// 8. 단답형
		// 삼항 연산자 ? (참):(거짓)
		
		// 9. 4번 생성자는 인터페이스에서 사용할 수 없습니다
		
		// 10. 2번 단 하나의 추상 메서드를 포함합니다.
		
		// 11. Child
		
		// 12. 2번 private static
		
		// 13. 2번 아니요
		
		// 14. 상속관계가 명확한지...? * 다운캐스팅 추가 공부 필요
		
		// 15. 2번 메서드체이닝 비슷한걸로 알고있습니다.
		
		// 16. 3번
		
		// 17. public
		
		// 18. 4번 추상 클래스는 정적메서드를 가질수있습니다 정적메서드 (static 메서드)
	}

}
