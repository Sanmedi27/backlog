package co.com.poli.taller.backlog.client;

import co.com.poli.taller.backlog.model.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "project-client")
public interface ProjectClient {
    @GetMapping(value = "/{project_identifier}")
    ResponseEntity<Project> getProjectByIdentifier(@PathVariable("project_identifier") String projectIdentifier) ;
}
