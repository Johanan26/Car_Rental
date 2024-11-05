package ie.atu.car_rental;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>>handlerValidationExceptions(MethodArgumentNotValidException ex)
    {
        Map<String,String>errorList = new HashMap<>();
        for(fieldError error:ex.getBindingResult().getFieldErrors()){
            String errorName = error.getField();
            String errorMessage = error.getDefaultMessage();
            String errorTimestamp = error.getDefaultTimestamp();
            errorList.put(errorName,errorMessage,errorTimestamp);
        }
        return ResponseEntity.status(400).body(errorList);
    }
}
