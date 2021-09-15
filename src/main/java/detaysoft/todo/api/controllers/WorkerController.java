package detaysoft.todo.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import detaysoft.todo.business.abstracts.WorkerService;
import detaysoft.todo.core.utilities.result.DataResult;
import detaysoft.todo.core.utilities.result.ErrorDataResult;
import detaysoft.todo.core.utilities.result.Result;
import detaysoft.todo.entities.concretes.Worker;
import detaysoft.todo.entities.dtos.WorkerDto;

@RestController
@RequestMapping("/api/workers")
public class WorkerController {

	private WorkerService workerService;

	@Autowired
	public WorkerController(WorkerService workerService) {
		super();
		this.workerService = workerService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody WorkerDto workerDto) {
		return ResponseEntity.ok(this.workerService.add(workerDto));
	}

	@PostMapping("/delete")
	public Result delete(Worker worker) {
		return this.workerService.delete(worker);
	}

	@GetMapping("/getAll")
	public DataResult<List<Worker>> getAll() {
		return this.workerService.getAll();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
		return errors;
	}

}
