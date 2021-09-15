package detaysoft.todo.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import detaysoft.todo.business.abstracts.WorkerService;
import detaysoft.todo.core.utilities.dtoConverter.abstracts.DtoConverterService;
import detaysoft.todo.core.utilities.result.DataResult;
import detaysoft.todo.core.utilities.result.Result;
import detaysoft.todo.core.utilities.result.SuccessDataResult;
import detaysoft.todo.core.utilities.result.SuccessResult;
import detaysoft.todo.dataAccess.abstracts.WorkerDao;
import detaysoft.todo.entities.concretes.Worker;
import detaysoft.todo.entities.dtos.WorkerDto;

@Service
public class WorkerManager implements WorkerService {
	
	private WorkerDao workerDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public WorkerManager(WorkerDao workerDao, DtoConverterService dtoConverterService) {
		super();
		this.workerDao = workerDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(WorkerDto workerDto) {
		this.workerDao.save((Worker)this.dtoConverterService.dtoClassConverter(workerDto, Worker.class));
		return new SuccessResult(" Çalışan başarıyla eklendi. ");
	}

	@Override
	public Result delete(Worker worker) {
		workerDao.delete(worker);
		return new SuccessResult(" Çalışan başarıyla silindi. ");
		
	}

	@Override
	public DataResult<List<Worker>> getAll() {
		return new SuccessDataResult<List<Worker>>(this.workerDao.findAll(), " Çalışan listesi başarıyla getirildi. ");
	}

}
