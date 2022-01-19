package com.skill;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice implements ErrorController
{
	ApiResponse apiResponse;

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ApiResponse> exceptionHandler(HttpServletRequest request, Throwable e)
	{
		apiResponse = new ApiResponse();
		apiResponse.setResponseCode(0);
		apiResponse.setData(null);
		apiResponse.setResponseMessage(Objects.isNull(e.getCause()) ? e.getMessage() : e.getCause().getMessage());
		if (e instanceof MethodArgumentNotValidException)
		{
			MethodArgumentNotValidException mex = (MethodArgumentNotValidException) e;
			BindingResult result = mex.getBindingResult();
			FieldError fErr = result.getFieldError();
			apiResponse.setResponseMessage(fErr.getDefaultMessage());
		}
		return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
