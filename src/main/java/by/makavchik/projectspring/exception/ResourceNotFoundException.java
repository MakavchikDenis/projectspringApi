package by.makavchik.projectspring.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException() {
    }
    public ResourceNotFoundException(String message) {
        super(message);}

    public ResourceNotFoundException(Long id) {
        super("Resource not found " + Long.toString(id));
    }

}
