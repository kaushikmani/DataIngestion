/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.dataingestion.jpa;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Kaushik Mani
 */
@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", length = 512)
    private long Id;

    @Column(name = "Json", columnDefinition = "TEXT", nullable = false)
    private String json;

    @Column(name = "Recievedat", nullable = false)
    private Date recievedAt;

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Date getRecievedAt() {
        return recievedAt;
    }

    public void setRecievedAt(Date recievedAt) {
        this.recievedAt = recievedAt;
    }

}
