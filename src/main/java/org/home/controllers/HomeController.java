package org.home.controllers;

import org.home.entities.Task;
import org.home.exceptions.NotFoundException;
import org.home.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private TasksRepository tasksRepository;

    @GetMapping("/")
    public String index(@RequestParam(name="name", required=false, defaultValue="Test") String name, Map<String, Object> model) {
        model.put("tasks", tasksRepository.findAll());
        return "index";
    }

    @GetMapping("/task")
    public String viewTask(@RequestParam Long id, Map<String, Object> model){
        Task task = tasksRepository.findById(id).orElse(null);
        if (task == null) {
            throw new NotFoundException();
        }
        model.put("task", task);
        return "viewTask";
    }

    @GetMapping("/createtask")
    public String createTask() { return "createTask"; }

    @PostMapping("/createtask")
    public RedirectView createTask(@RequestParam String taskName,
                                   @RequestParam String description,
                                   @RequestParam String beginData,
                                   @RequestParam String endData,
                                   @RequestParam String taskAuthor,
                                   Map<String, Object> model){

        if(!taskName.equals(null) && !taskName.equals("")){
            Task newTask = new Task(0, taskName, description, "Да", beginData, endData, "Нет", taskAuthor);
            try{
                tasksRepository.save(newTask);
            } catch (Exception ex){
                System.out.println("Ошибка записи в базу данных");
                System.out.println(ex);
            }

        }
        return new RedirectView("/");
    }

    @GetMapping("/remove")
    public RedirectView removeTask (@RequestParam Long id, Map<String, Object> model){
        Task removeTask = tasksRepository.findById(id).orElse(null);
        if(removeTask != null){
            tasksRepository.deleteById(id);
        }
        return new RedirectView("/");
    }

    @GetMapping("/edit")
    public String editTask(@RequestParam Long id, Map<String, Object> model){
        Task editTask = tasksRepository.findById(id).orElse(null);
        if (editTask == null) {
            throw new NotFoundException();
        }
        model.put("task", editTask);
        return("editTask");
    }

    @PostMapping("/edit")
    public RedirectView editTask(@RequestParam Long id,
                                 @RequestParam String taskName,
                                 @RequestParam String description,
                                 @RequestParam String isActual,
                                 @RequestParam String beginData,
                                 @RequestParam String endData,
                                 @RequestParam String isCompleted,
                                 @RequestParam String taskAuthor,
                                 Map<String, Object> model){
        Task editTask = tasksRepository.findById(id).orElse(null);
        if (editTask == null) {
            throw new NotFoundException();
        }
        editTask.setTaskName(taskName);
        editTask.setDescription(description);
        editTask.setIsActual(isActual);
        editTask.setBeginData(beginData);
        editTask.setEndData(endData);
        editTask.setIsCompleted(isCompleted);
        editTask.setTaskAuthor(taskAuthor);
        tasksRepository.save(editTask);
        return new RedirectView("/");
    }
}