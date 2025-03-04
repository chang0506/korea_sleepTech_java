package todo_app.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task {
	private Long id; // 할 일의 고유번호
	private Long userId; // 유저 아이디
	private String text;
	private String nickname;
	private Date date;
	
	public final void setText(String text) {
		this.text = text;
	}
	
	public final void setDate(Date date) {
		this.date = date;
	}
}