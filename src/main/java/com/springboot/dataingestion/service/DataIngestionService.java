/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.dataingestion.service;

import com.springboot.dataingestion.jpa.Patient;
import com.springboot.dataingestion.repository.PatientRepository;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Kaushik Mani
 */
@Service
public class DataIngestionService {

    @Autowired
    private PatientRepository patientRepository;

    public void uploadDocument(InputStream inputStream) throws IOException {

        Patient patient = new Patient();
        String json = IOUtils.toString(inputStream);
        patient.setJson(json);
        patient.setRecievedAt(new Date());

        patientRepository.save(patient);
    }
}
