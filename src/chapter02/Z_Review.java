package chapter02;

public class Z_Review {
	public static void main(String[] args) {
//      *****
//      ****
//      ***
//      **
//      *

//      *****
//       ****
//        ***
//         **
//          *
		for (int i = 0; i < 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 5; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}