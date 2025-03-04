package todo_app.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TaskReqDto {
	private Long id;
	private Long userId;
	private String text;
	private String nickname;
	private Date date;
}
