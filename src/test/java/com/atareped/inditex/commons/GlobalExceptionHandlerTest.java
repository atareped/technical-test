package com.atareped.inditex.commons;

import com.atareped.inditex.commons.exceptions.GlobalExceptionHandler;
import com.atareped.inditex.commons.exceptions.PriceNotFoundException;
import com.atareped.inditex.commons.exceptions.UnexpectedDataBaseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    void shouldHandlePriceNotFoundException(){
        String message = "No price could be found";
        PriceNotFoundException ex = new PriceNotFoundException(message);
        ResponseEntity<Object> response = globalExceptionHandler.handePriceNotFoundException(ex, null);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().toString().contains(message));
    }

    @Test
    void shouldHandleUnexpectedDataBaseException(){
        String message = "Internal server error";
        String expectedMessage = "Something went wrong in the database: " + message;
        UnexpectedDataBaseException ex = new UnexpectedDataBaseException(message);
        ResponseEntity<Object> response = globalExceptionHandler.handleUnexpectedDataBaseException(ex, null);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().toString().contains(expectedMessage));
    }
}
