package detaysoft.todo.entities.concretes;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "worker")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","toDo"})
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "worker_first_name")
	private String workerFirstName;
	
	@Column(name = "worker_last_name")
	private String workerLastName;
	
	@Column(name = "worker_email")
	@Email
	@NotBlank
	@NotNull
	private String workerEmail;
	
	@Column(name = "password")
	@NotBlank
	@NotNull
	private String password;
	
	@OneToMany(mappedBy = "worker")
	private List<ToDo> toDo;
}
