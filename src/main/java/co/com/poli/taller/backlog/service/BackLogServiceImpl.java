package co.com.poli.taller.backlog.service;

import co.com.poli.taller.backlog.domain.BackLog;
import co.com.poli.taller.backlog.repository.BackLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackLogServiceImpl implements BackLogService {
    private final BackLogRepository backLogRepository;

    public BackLogServiceImpl(BackLogRepository backLogRepository) {
        this.backLogRepository = backLogRepository;
    }

    @Override
    public List<BackLog> getAllBackLogs() {
        return backLogRepository.findAll();
    }

    @Override
    public BackLog getBackLog(Long id) {
        return backLogRepository.findById(id).orElse(null);
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
