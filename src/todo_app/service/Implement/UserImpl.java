package todo_app.service.Implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import todo_app.dto.request.UserSignupReqDto;
import todo_app.dto.response.UserRespDto;
import todo_app.entity.User;
import todo_app.repository.UserRepository;
import todo_app.service.UserService;

public class UserImpl implements UserService {
	private final UserRepository repository;
	private User loggedUser;
	private static long CurrentId = 1; // 유저 고유번호 관리

	public UserImpl() {
		this.repository = UserRepository.getInstance();
	}

	private Long generateId() {
		return CurrentId++;
	}

	@Override
	public void signUp(UserSignupReqDto dto) {
		Optional<User> optionalUser = repository.findById(dto.getId());

		try {
			String pw = dto.getPassword();
			String pwCheck = dto.getPasswordCheck();
			if (!pw.equals(pwCheck)) {
				throw new Error("비밀번호가 동일하지 않습니다.");
			}
			if (optionalUser.isPresent()) {
				System.out.println("해당 ID의 유저가 존재합니다. 다시 시도해주세요.");
				return;
			}

			User user = new User(generateId(), dto.getUserId(), dto.getPassword(), dto.getUsername(), dto.getEmail(),
					dto.getPhone(), dto.getAge(), dto.getNickname());
			repository.save(user);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void signIn(String userId, String password) {
		repository.findByUserId(userId).ifPresentOrElse(user -> {
			if (user.getPassword().equals(password)) {
				loggedUser = user;
				System.out.println("로그인 성공: " + user.getUsername());
			} else {
				System.out.println("로그인 실패: 비밀번호가 일치하지 않습니다.");
			}
		}, () -> System.out.println("로그인 실패: 사용자 ID를 찾을 수 없습니다."));
	}
	
	@Override
	public void logout() {
		if (loggedUser != null) {
			// 로그인 중
			System.out.println("로그아웃 성공: " + loggedUser.getUsername());
			loggedUser = null;
		} else {
			System.out.println("로그인 상태가 아닙니다. 로그아웃할 수 없습니다.");
		}
		
	}
	
	@Override
	public boolean isLoggedIn() {
		boolean result = loggedUser != null;
		// 로그인 중: true / 로그인 중 X: false
		return result;
	}

	@Override
	public List<UserRespDto> getAllUser() {
		List<User> users = repository.findAll();
		
		List<UserRespDto> respDtos = users.stream()
				.map(user -> new UserRespDto(user.getId(), user.getUserId(), user.getNickname()))
				.collect(Collectors.toList());
		return respDtos;
	}

	@Override
	public UserRespDto getUserById(Long id) {
		UserRespDto respDto = null;
		
		try {
			User user = repository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 아이디는 존재하지 않습니다." + id));
			respDto = new UserRespDto(id, user.getUserId(), user.getNickname());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return respDto;
		
	}

	@Override
	public void deleteUser(Long id) {
		try {
			User user = repository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 유저를 찾을 수 없습니다." + id));
			
			repository.delete(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
