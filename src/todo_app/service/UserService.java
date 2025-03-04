package todo_app.service;

import java.util.List;

import todo_app.dto.request.UserSignupReqDto;
import todo_app.dto.response.UserRespDto;

public interface UserService {
	void signUp(UserSignupReqDto dto);
	void signIn(String userId, String password);
	void logout();
	boolean isLoggedIn(); // 사용자의 로그인 유무를 확인
	List<UserRespDto> getAllUser();
	UserRespDto getUserById(Long id);
	void deleteUser(Long id);
}
