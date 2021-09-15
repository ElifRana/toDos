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
import detaysoft.todo.business.abstracts.ExecutiveService;
import detaysoft.todo.core.utilities.result.DataResult;
import detaysoft.todo.core.utilities.result.ErrorDataResult;
import detaysoft.todo.core.utilities.result.Result;
import detaysoft.todo.entities.concretes.Executive;
import detaysoft.todo.entities.dtos.ExecutiveDto;

@RestController
@RequestMapping("/api/executives")
public class ExecutiveController {

	private ExecutiveService executiveService;

	@Autowired
	public ExecutiveController(ExecutiveService executiveService) {
		super();
		this.executiveService = executiveService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ExecutiveDto executiveDto) {
		return ResponseEntity.ok(this.executiveService.add(executiveDto));
	}

	@PostMapping("/delete")
	public Result delete(Executive executive) {
		return this.executiveService.delete(executive);
	}

	@GetMapping("/getAll")
	public DataResult<List<Executive>> getAll() {
		return this.executiveService.getAll();
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
