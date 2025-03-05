package todo_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserSignupReqDto {
	private Long id;
	private String userId;
	private String password;
	private String passwordCheck;
	private String username;
	private String email;
	private String phone;
	private int age;
	private String nickname;
}
