package todo_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserSigninReqDto {
	private String userId;
	private String password;
}
