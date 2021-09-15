package detaysoft.todo.business.abstracts;

import java.util.List;
import detaysoft.todo.core.utilities.result.DataResult;
import detaysoft.todo.core.utilities.result.Result;
import detaysoft.todo.entities.concretes.Executive;
import detaysoft.todo.entities.dtos.ExecutiveDto;

public interface ExecutiveService {

	Result add(ExecutiveDto executiveDto);

	Result delete(Executive executive);

	DataResult<List<Executive>> getAll();
}
