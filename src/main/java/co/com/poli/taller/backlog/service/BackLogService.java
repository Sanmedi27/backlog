package co.com.poli.taller.backlog.service;
import co.com.poli.taller.backlog.domain.BackLog;

import java.util.List;
public interface BackLogService {
    List<BackLog> getAllBackLogs();
    BackLog getBackLog(Long id);
    BackLog createBackLog(BackLog backLog);
}
