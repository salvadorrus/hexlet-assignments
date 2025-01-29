package exercise.controller;

import java.util.List;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.mapper.TaskMapper;
import exercise.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    // BEGIN
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskMapper taskMapper;

    @GetMapping
    public List<TaskDTO> index() {
        var tasks = taskRepository.findAll();
        var taskDTO = tasks.stream()
                .map(task -> taskMapper.map(task)).toList();
        return taskDTO;
    }
    @GetMapping("/{id}")
    public TaskDTO show(@PathVariable long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        return taskMapper.map(task);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDTO create(@RequestBody TaskCreateDTO taskCreate) {
        var task = taskMapper.map(taskCreate);
        taskRepository.save(task);
        return taskMapper.map(task);
    }
    @PutMapping("/{id}")
    public TaskDTO update(@PathVariable long id, @Valid @RequestBody TaskUpdateDTO taskUpdate) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        var user = userRepository.findById(taskUpdate.getAssigneeId())
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        taskMapper.update(taskUpdate, task);
        task.setAssignee(user);
        taskRepository.save(task);
        return taskMapper.map(task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found"));
        taskRepository.delete(task);
    }
    // END
}
