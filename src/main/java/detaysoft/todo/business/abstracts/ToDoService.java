package detaysoft.todo.business.abstracts;

import java.util.List;
import detaysoft.todo.core.utilities.result.DataResult;
import detaysoft.todo.core.utilities.result.Result;
import detaysoft.todo.entities.concretes.ToDo;
import detaysoft.todo.entities.dtos.ToDoDto;

public interface ToDoService {

	Result add(ToDoDto toDoDto);
	
	Result delete(ToDo toDo);
	
	// Result update(ToDoDto toDoDto);
	
	DataResult<List<ToDo>> getAll();
	
	DataResult<ToDo> getByWorkerId(int workerId);
}
