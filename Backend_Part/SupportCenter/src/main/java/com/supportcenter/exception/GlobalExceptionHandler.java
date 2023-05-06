package com.supportcenter.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorDetails> myException(Exception se , WebRequest req){

	        ErrorDetails med = new ErrorDetails();
	        med.setTime(LocalDateTime.now());
	        med.setMessage(se.getMessage());
	        med.setDescription(req.getDescription(false));

	        return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST) ;
	    }

	    @ExceptionHandler(NoHandlerFoundException.class)
	    public ResponseEntity<ErrorDetails> NoHandlerFound(NoHandlerFoundException se , WebRequest req){

	        ErrorDetails med = new ErrorDetails();
	        med.setTime(LocalDateTime.now());
	        med.setMessage(se.getMessage());
	        med.setDescription(req.getDescription(false));

	        return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST) ;
	    }

	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ErrorDetails> myException(MethodArgumentNotValidException se , WebRequest req){

	        ErrorDetails med = new ErrorDetails();
	        med.setTime(LocalDateTime.now());
	        med.setMessage(se.getMessage());
	        med.setDescription(req.getDescription(false));

	        return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST) ;
	    }

	    @ExceptionHandler(CallException.class)
	    public ResponseEntity<ErrorDetails> myException(CallException se , WebRequest req){

	        ErrorDetails med = new ErrorDetails();
	        med.setTime(LocalDateTime.now());
	        med.setMessage(se.getMessage());
	        med.setDescription(req.getDescription(false));

	        return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST) ;
	    }
	    
	    
	    @ExceptionHandler(IssueException.class)
	    public ResponseEntity<ErrorDetails> myException(IssueException se , WebRequest req){

	        ErrorDetails med = new ErrorDetails();
	        med.setTime(LocalDateTime.now());
	        med.setMessage(se.getMessage());
	        med.setDescription(req.getDescription(false));

	        return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST) ;
	    }
	    @ExceptionHandler(OperatorException.class)
	    public ResponseEntity<ErrorDetails> myException(OperatorException se , WebRequest req){

	        ErrorDetails med = new ErrorDetails();
	        med.setTime(LocalDateTime.now());
	        med.setMessage(se.getMessage());
	        med.setDescription(req.getDescription(false));

	        return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST) ;
	    }
	    @ExceptionHandler(LogInException.class)
	    public ResponseEntity<ErrorDetails> myException(LogInException se , WebRequest req){

	        ErrorDetails med = new ErrorDetails();
	        med.setTime(LocalDateTime.now());
	        med.setMessage(se.getMessage());
	        med.setDescription(req.getDescription(false));

	        return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST) ;
	    }
	    
	    @ExceptionHandler(DepartmentException.class)
	    public ResponseEntity<ErrorDetails> myException(DepartmentException se , WebRequest req){

	        ErrorDetails med = new ErrorDetails();
	        med.setTime(LocalDateTime.now());
	        med.setMessage(se.getMessage());
	        med.setDescription(req.getDescription(false));

	        return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST) ;
	    }
	    
	    
	    @ExceptionHandler(CustomerException.class)
	    public ResponseEntity<ErrorDetails> myException(CustomerException se , WebRequest req){

	        ErrorDetails med = new ErrorDetails();
	        med.setTime(LocalDateTime.now());
	        med.setMessage(se.getMessage());
	        med.setDescription(req.getDescription(false));

	        return new ResponseEntity<>(med, HttpStatus.BAD_REQUEST) ;
	    }
	}
