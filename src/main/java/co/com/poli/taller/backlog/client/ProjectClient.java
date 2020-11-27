package co.com.poli.taller.backlog.client;

import co.com.poli.taller.backlog.model.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-project")
@RequestMapping(value = "/project")
public interface ProjectClient {
    public ResponseEntity<Project> getProjectByIdentifier(@PathVariable("projectIdentifier") String projectIdentifier) ;
}
