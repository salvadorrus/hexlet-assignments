package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import exercise.model.Task;
import exercise.repository.TaskRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping(path = "")
    public List<Task> index() {
        return taskRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Task show(@PathVariable long id) {

        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task with id " + id + " not found"));

        return task;
    }

    // BEGIN
//    @PostMapping(path = "")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void create(@RequestBody Task task) {
//        if (taskRepository.findAll().contains(task)) {
//            throw new ResourceNotFoundException("Product " + task.getTitle() + " already exists");
//        } else {
//            taskRepository.save(task);
//        }
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody Task task) {
        taskRepository.save(task);
        return task;
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable long id, @RequestBody Task taskData) {
        var task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        task.setTitle(taskData.getTitle());
        task.setDescription(taskData.getDescription());

        taskRepository.save(task);

        return task;
    }
    // END

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        taskRepository.deleteById(id);
    }
}
