package detaysoft.todo.core.utilities.result;

public class ErrorResult extends Result{

	public ErrorResult(boolean success) {
		super(success);
	}
	
	public ErrorResult(String message) {
		super(false, message);
	}
}
