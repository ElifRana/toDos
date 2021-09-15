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
import detaysoft.todo.business.abstracts.ToDoService;
import detaysoft.todo.core.utilities.result.DataResult;
import detaysoft.todo.core.utilities.result.ErrorDataResult;
import detaysoft.todo.core.utilities.result.Result;
import detaysoft.todo.entities.concretes.ToDo;
import detaysoft.todo.entities.dtos.ToDoDto;

@RestController
@RequestMapping("/api/toDos")
public class ToDoController {

	private ToDoService toDoService;

	@Autowired
	public ToDoController(ToDoService toDoService) {
		super();
		this.toDoService = toDoService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ToDoDto toDoDto){
        return ResponseEntity.ok(this.toDoService.add(toDoDto));
    }
	
	@GetMapping("/getByWorkerId")
	public DataResult<ToDo> getByWorkerId(int workerId){
		return this.toDoService.getByWorkerId(workerId);
	}
	
	@PostMapping("/delete")
	public Result delete(ToDo toDo) {
		return this.toDoService.delete(toDo);
	}
	
//	@PostMapping("/update")
//	public ResponseEntity<?> update(@Valid @RequestBody ToDoDto toDoDto) {
//		return ResponseEntity.ok(this.toDoService.update(toDoDto));
//	}
//	
	@GetMapping("/getAll")
	public DataResult<List<ToDo>> getAll() {
		return this.toDoService.getAll();
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
