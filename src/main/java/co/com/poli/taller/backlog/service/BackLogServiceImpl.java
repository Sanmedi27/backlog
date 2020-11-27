package co.com.poli.taller.backlog.service;

import co.com.poli.taller.backlog.client.ProjectClient;
import co.com.poli.taller.backlog.client.ProjectTaskClient;
import co.com.poli.taller.backlog.domain.BackLog;
import co.com.poli.taller.backlog.model.Project;
import co.com.poli.taller.backlog.model.ProjectTask;
import co.com.poli.taller.backlog.repository.BackLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackLogServiceImpl implements BackLogService {
    private final BackLogRepository backLogRepository;
    private final ProjectClient projectClient;
    private final ProjectTaskClient projectTaskClient;

    public BackLogServiceImpl(BackLogRepository backLogRepository,
                              ProjectClient projectClient,
                              ProjectTaskClient projectTaskClient) {
        this.backLogRepository = backLogRepository;
        this.projectClient = projectClient;
        this.projectTaskClient = projectTaskClient;
    }

    @Override
    public List<BackLog> getAllBackLogs() {
        return backLogRepository.findAll();
    }

    @Override
    public BackLog getBackLog(Long id) {
        BackLog backLog = backLogRepository.findById(id).orElse(null);
        if (backLog != null) {
            Project project = projectClient.getProjectByIdentifier(backLog.getProjectIdentifier()).getBody();
            backLog.setProject(project);
            List<ProjectTask> projectTaskList = projectTaskClient.listAllProjectTask().getBody();
            backLog.setProjectTask(projectTaskList);
        }
        return backLog;
    }

    @Override
    public BackLog createBackLog(BackLog backLog) {
        return backLogRepository.save(backLog);
    }

    public BackLog updateBackLog(BackLog backLog) {
        BackLog backLogBD = getBackLog(backLog.getId());
        if (backLogBD == null) {
            return null;
        }
        backLogBD.setProjectIdentifier(backLog.getProjectIdentifier());
        return backLogRepository.save(backLogBD);
    }
}
