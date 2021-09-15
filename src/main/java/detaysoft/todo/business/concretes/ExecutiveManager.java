package detaysoft.todo.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import detaysoft.todo.business.abstracts.ExecutiveService;
import detaysoft.todo.core.utilities.dtoConverter.abstracts.DtoConverterService;
import detaysoft.todo.core.utilities.result.DataResult;
import detaysoft.todo.core.utilities.result.Result;
import detaysoft.todo.core.utilities.result.SuccessDataResult;
import detaysoft.todo.core.utilities.result.SuccessResult;
import detaysoft.todo.dataAccess.abstracts.ExecutiveDao;
import detaysoft.todo.entities.concretes.Executive;
import detaysoft.todo.entities.dtos.ExecutiveDto;

@Service
public class ExecutiveManager implements ExecutiveService {

	private ExecutiveDao executiveDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public ExecutiveManager(ExecutiveDao executiveDao, DtoConverterService dtoConverterService) {
		super();
		this.executiveDao = executiveDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(ExecutiveDto executiveDto) {
		this.executiveDao.save((Executive) this.dtoConverterService.dtoClassConverter(executiveDto, Executive.class));
		return new SuccessResult(" Çalışan başarıyla eklendi. ");
	}

	@Override
	public Result delete(Executive executive) {
		executiveDao.delete(executive);
		return new SuccessResult(" Yönetici başarıyla silindi. ");
	}

	@Override
	public DataResult<List<Executive>> getAll() {
		return new SuccessDataResult<List<Executive>>(this.executiveDao.findAll(), " Yönetici listesi başarıyla getirildi.");
	}

}
