package co.com.poli.taller.backlog.repository;
import co.com.poli.taller.backlog.domain.BackLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackLogRepository extends JpaRepository<BackLog, Long>{
}
