package dev.gourav.ecomm.productservice.Advice;

import dev.gourav.ecomm.productservice.Exceptions.ProductNotFoundException;
import dev.gourav.ecomm.productservice.dto.ErrorDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler (NullPointerException.class)
    public ResponseEntity<ErrorDto> nullPointerException(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setError("something went wrong");

        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto,
                               HttpStatusCode.valueOf(201));
        return responseEntity;
    }

    @ExceptionHandler(ProductNotFoundException.class)
        public ResponseEntity<ErrorDto> productNotFound(){
            ErrorDto errorDto = new ErrorDto();
            errorDto.setError("product not found");

            ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto,
                    HttpStatusCode.valueOf(404));

            return responseEntity;
        }


}
