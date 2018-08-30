/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.dataingestion.repository;

import com.springboot.dataingestion.jpa.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kaushik Mani
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

}
