package chapter13;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class LombokExample {
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
}
public class G_Lombok {
	public static void main(String[] args) {
		LombokExample test = new LombokExample();
		
		test.setName("Lombok 테스트");
		test.setAge(25);
		
		System.out.println(test.getAge());
		System.out.println(test.getName());
	}
}
