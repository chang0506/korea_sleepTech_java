package todo_app.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskRespDto {
	private Long id; // 할 일 고유번호
	private Long userId; // 유저 고유번호
	private String text;
	private String nickname;
	private Date date; // 게시된 날짜
}
