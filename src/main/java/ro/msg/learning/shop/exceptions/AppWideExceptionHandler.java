package ro.msg.learning.shop.exceptions;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AppWideExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NullProductException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object nullProductExceptionHandler(NullProductException e) {
        return new HttpEntity<>(e.getMessage() + e.getCause().getMessage());
    }


    @ExceptionHandler({StockConsistencyException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Object stockConsistencyExceptionHandler(StockConsistencyException e) {
        return new HttpEntity<>(e.getMessage() + e.getCause().getMessage());
    }


    @ExceptionHandler({NegativeInputParameterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails handleIllegalArgumentException(HttpServletRequest request, Exception ex) {
        request.removeAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE);
        request.setAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE, Collections.singleton(MediaType.APPLICATION_JSON));

        return new ErrorDetails(request.getRequestURL().toString(), ex.getMessage());
    }


    @ExceptionHandler({NegativeQuantityException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails negativeQuantityExceptionHandler(HttpServletRequest request, Exception ex) {
        return new ErrorDetails(request.getRequestURL().toString(), ex.getMessage());
    }


    @ExceptionHandler({LocationNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDetails locationNotFoundExceptionHandler(HttpServletRequest request, Exception ex) {
        request.removeAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE);
        request.setAttribute(HandlerMapping.PRODUCIBLE_MEDIA_TYPES_ATTRIBUTE, Collections.singleton(MediaType.APPLICATION_JSON));

        return new ErrorDetails(request.getRequestURL().toString(), ex.getMessage());
    }

}
