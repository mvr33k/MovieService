package pl.pjatk.MovieService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//@RestControllerAdvice
//public class MovieAdvice {
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> MovieNotFoundException(RuntimeException ex){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body("Element not found.");
//    }
//
//    public ResponseEntity<String> BadRequestException(IllegalArgumentException  ex) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body("Bad request");
//    }
//}

import java.util.NoSuchElementException;


@RestControllerAdvice
public class MovieAdvice {

    @ExceptionHandler
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}