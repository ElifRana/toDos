package detaysoft.todo.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import detaysoft.todo.business.abstracts.ToDoService;
import detaysoft.todo.core.utilities.dtoConverter.abstracts.DtoConverterService;
import detaysoft.todo.core.utilities.result.DataResult;
import detaysoft.todo.core.utilities.result.ErrorResult;
import detaysoft.todo.core.utilities.result.Result;
import detaysoft.todo.core.utilities.result.SuccessDataResult;
import detaysoft.todo.core.utilities.result.SuccessResult;
import detaysoft.todo.dataAccess.abstracts.ToDoDao;
import detaysoft.todo.dataAccess.abstracts.WorkerDao;
import detaysoft.todo.entities.concretes.ToDo;
import detaysoft.todo.entities.concretes.Worker;
import detaysoft.todo.entities.dtos.ToDoDto;

@Service
public class ToDoManager implements ToDoService {
	
	private ToDoDao toDoDao;
	private DtoConverterService dtoConverterService;
	private WorkerDao workerDao;
	
	@Autowired
	public ToDoManager(ToDoDao toDoDao, DtoConverterService dtoConverterService, WorkerDao workerDao) {
		super();
		this.toDoDao = toDoDao;
		this.dtoConverterService = dtoConverterService;
		this.workerDao = workerDao;
	}

	@Override
	public Result add(ToDoDto toDoDto) {
		this.toDoDao.save((ToDo)this.dtoConverterService.dtoClassConverter(toDoDto, ToDo.class));
		return new SuccessResult(" Görev başarıyla eklendi.");
	}

	@Override
	public DataResult<ToDo> getByWorkerId(int workerId) {
		return new SuccessDataResult<ToDo>(this.toDoDao.findByWorkerId(workerId), "Çalışanın görevleri id ye göre getirildi");
	}

	@Override
	public Result delete(ToDo toDo) {
		toDoDao.delete(toDo);
		return new SuccessResult(" Görev başarıyla silindi. ");
	}

	@Override
	public DataResult<List<ToDo>> getAll() {
		return new SuccessDataResult<List<ToDo>>(this.toDoDao.findAll(), " Tüm görevler getirildi. ");
	}

//	@Override
//	public Result update(ToDoDto toDoDto) {
//		ToDo toDo = this.toDoDao.findById(toDoDto.getId()).orElse(null);
//		Worker worker = this.workerDao.findById(toDoDto.getWorkerId()).orElse(null);
//		
//		if(toDo != null) {
//			toDo.setWorker(worker);
//			this.toDoDao.save(toDo);
//			return new SuccessResult(" Görev güncellendi. ");
//		}
//		return new ErrorResult(" Görevler güncellenemedi. ");
//	}

}
