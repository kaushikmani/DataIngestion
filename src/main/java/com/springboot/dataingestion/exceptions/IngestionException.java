/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.dataingestion.exceptions;

/**
 *
 * @author Kaushik Mani
 */
public class IngestionException extends Exception {

    private int code;

    public int getCode() {
        return code;
    }

    public IngestionException(int code, String message) {
        super(message);
        this.code = code;
    }

    public IngestionException(String message) {
        super(message);
    }

    public IngestionException(Throwable cause) {
        super(cause);
    }

    public IngestionException(String message, Throwable cause) {
        super(message, cause);
    }
}
