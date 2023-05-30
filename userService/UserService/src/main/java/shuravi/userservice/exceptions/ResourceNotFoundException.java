package shuravi.userservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(){
    super("Resource not found on the server");
  }

  public ResourceNotFoundException(String message){
    super(message);
  }
}
