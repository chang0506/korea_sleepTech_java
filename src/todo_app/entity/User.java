package todo_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter         
public class User {
	private Long id; // 유저의 고유 번호
	private String userId; // 유저의 아이디
	private String password;
	private String username;
	private String email;
	private String phone;
	private int age;
	private String nickname;
}
