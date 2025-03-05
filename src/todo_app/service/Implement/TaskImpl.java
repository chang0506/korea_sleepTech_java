package todo_app.service.Implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import todo_app.dto.request.TaskReqDto;
import todo_app.dto.response.TaskRespDto;
import todo_app.entity.Task;
import todo_app.entity.User;
import todo_app.repository.TaskRepository;
import todo_app.repository.UserRepository;
import todo_app.service.TaskService;

public class TaskImpl implements TaskService {
	private final TaskRepository taskRep;
	private final UserRepository userRep;
	
	private static long currentId = 1;
	
	public TaskImpl() {
		this.taskRep = TaskRepository.getInstance();
		this.userRep = UserRepository.getInstance();
	}
	
	private Long generatedRecordId() {
		return currentId++;
	}
	
	private void validateUser(Long id) {
		Optional<User> foundUser = userRep.findById(id);
		
		if (!foundUser.isPresent()) {
			throw new IllegalArgumentException("해당 ID의 유저를 찾을 수 없습니다" + id);
		}
	}
	
	@Override
	public void createTask(TaskReqDto dto) {
		try {
			validateUser(dto.getUserId());
			
			Task task = new Task(generatedRecordId(), dto.getUserId(), dto.getText(), dto.getTitle(), dto.getDate());
			taskRep.save(task);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<TaskRespDto> getAllTasks() {
		List<TaskRespDto> respDtos = null;
		try {
			List<Task> tasks = taskRep.findAll();
			
			respDtos = tasks.stream()
					.map(t -> new TaskRespDto(t.getId(), t.getUserId(), t.getText(),t.getTitle(), t.getDate()))
							.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return respDtos;
	}

	@Override
	public List<TaskRespDto> filterTasksByText(String text) {
		List<TaskRespDto> respDto = null;
		
		try {
			List<Task> tasks = taskRep.findAll();
			
			respDto = tasks.stream()
					.filter(c -> c.getText().contains(text))
					.map(t -> new TaskRespDto(t.getId(), t.getUserId(), t.getText(),t.getTitle(), t.getDate()))
					.collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return respDto;
	}

	@Override
	public void updateText(Long id, TaskReqDto dto) {
		try {
			Task task = taskRep.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 id 유저가 없습니다." + id));
			task.setText(dto.getText());
			task.setDate(dto.getDate());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void deleteText(Long id) {
		try {
			Task task = taskRep.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("해당 ID의 할일이 없습니다: " + id));
			taskRep.delete(task);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	 
}
