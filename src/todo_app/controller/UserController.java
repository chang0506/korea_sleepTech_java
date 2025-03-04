package todo_app.controller;

import java.util.List;

import todo_app.dto.request.UserSigninReqDto;
import todo_app.dto.request.UserSignupReqDto;
import todo_app.dto.response.UserRespDto;
import todo_app.service.UserService;
import todo_app.service.Implement.UserImpl;

public class UserController {
	public UserService service;
	
	public UserController() {
		this.service = new UserImpl();
	}
	
	public void signUpUser(UserSignupReqDto dto) {
		service.signUp(dto);
	}
	
	public void signInUser(UserSigninReqDto dto) {
		service.signIn(dto.getUserId(), dto.getPassword());
	}
	
	public List<UserRespDto> getAllUser() {
		List<UserRespDto> users = service.getAllUser();
		return users;
	}
	
	public UserRespDto getUserById(Long id) {
		UserRespDto users = service.getUserById(id);
		return users;
	}
	
	public void deleteUser(Long id) {
		service.deleteUser(id);
	}
	
	
}
