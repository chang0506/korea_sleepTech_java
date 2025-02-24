package chapter13;

// 제네릭 와일드 카드 정리 //
// 1. 일반 와일드 카드: 모든 타입 허용 <?>
// 2. 상한 제한 와일드 카드: 특정 타입 & 그 하위 클래스만 허용 <? extends Number>
// 3. 하한 제한 와일드 카드: 특정 타입 & 그 상위 클래스만 허용 <? super Integer>

// == 주문 관리 시스템 == //
// 상품(Product)과 할인(Discount) 정보를 관리
// : 할인 정책 사용 시, Product 또는 Product를 상속받는 하위 클래스에서만 적용

// 1. 상우 ㅣ클래스
class Product {
	private String name;
	private int price;
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() { return name; }
	public int getPrice() { return price; }
}

public class C_Generic {

}
