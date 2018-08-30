/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.dataingestion.controller;

import com.springboot.dataingestion.exceptions.IngestionException;
import com.springboot.dataingestion.service.DataIngestionService;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Kaushik Mani
 */
@RestController
public class DataIngestionController {

    @Autowired
    private DataIngestionService dataIngestionService;

    @RequestMapping(path = "/v1/upload/",
            consumes = {"multipart/form-data", "application/x-www-form-urlencoded"},
            produces = "application/json; charset=UTF-8",
            method = RequestMethod.POST)
    public void uploadDocuments(@RequestParam("file") MultipartFile file) throws IngestionException {

        try {
            if (!file.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
                throw new IngestionException(400, "Content type not supported");
            }
            dataIngestionService.uploadDocument(file.getInputStream());
        } catch (IOException ex) {
            throw new IngestionException("Ingestion Exception: " + ex.getMessage());
        }
    }

    @ExceptionHandler(IngestionException.class)
    void handleIngestionException(HttpServletResponse response, IngestionException exception) throws IOException {
        if (exception.getCode() == 400) {
            response.sendError(HttpStatus.BAD_REQUEST.value());
        } else {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
