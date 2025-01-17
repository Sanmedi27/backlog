package co.com.poli.taller.backlog.client;

import co.com.poli.taller.backlog.model.ProjectTask;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "projecttask-service")
@RequestMapping(value = "/task")
public interface ProjectTaskClient {
    @GetMapping
    ResponseEntity<List<ProjectTask>> listAllProjectTask();
}
