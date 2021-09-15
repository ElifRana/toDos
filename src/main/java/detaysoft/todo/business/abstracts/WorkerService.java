package detaysoft.todo.business.abstracts;

import java.util.List;
import detaysoft.todo.core.utilities.result.DataResult;
import detaysoft.todo.core.utilities.result.Result;
import detaysoft.todo.entities.concretes.Worker;
import detaysoft.todo.entities.dtos.WorkerDto;

public interface WorkerService {

	Result add(WorkerDto workerDto);
	
	Result delete(Worker worker);
	
	DataResult<List<Worker>> getAll();
}
