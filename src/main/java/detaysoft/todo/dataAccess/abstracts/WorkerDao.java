package detaysoft.todo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import detaysoft.todo.entities.concretes.Worker;

public interface WorkerDao extends JpaRepository<Worker, Integer>{

}
