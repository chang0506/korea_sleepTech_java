package otherPackage;

public class PublicClass {
	public String publicField = "어디서든 접근 가능한 필드";
	public void publicMethod() {
		System.out.println("어디서든지 접근 가능한 메서드");
	}
	public static void main(String[] args) {
		PublicClass publicClass = new PublicClass();
		System.out.println(publicClass.publicField);
		publicClass.publicMethod();
	}
}
