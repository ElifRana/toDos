package detaysoft.todo.entities.dtos;

import detaysoft.todo.entities.concretes.Worker;
import lombok.Data;

@Data
public class ToDoDto {
	
	private int id;
	
	private String name;
	
	private Worker worker;
	
//	private int workerId;
}
