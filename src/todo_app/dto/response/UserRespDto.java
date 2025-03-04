package todo_app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserRespDto {
	private Long id;
	private String userId;
	private String nickname;
}
