package todo_app.controller;

import java.util.List;

import todo_app.dto.request.TaskReqDto;
import todo_app.dto.response.TaskRespDto;
import todo_app.service.TaskService;
import todo_app.service.Implement.TaskImpl;

public class TaskController {
	private TaskService service;
	
	public TaskController() {
		this.service = new TaskImpl();
	}
	
	public void createTask(TaskReqDto dto) {
		service.createTask(dto);
	}
	
	public List<TaskRespDto> getAllTask() {
		return service.getAllTasks();
	}
	
	public List<TaskRespDto> filterTasksByText(String text) {
		return service.filterTasksByText(text);
	}
	
	public void deleteTask(Long id) {
		service.deleteText(id);
	}
}
