/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.entity;

import com.websystique.springmvc.model.Hobby;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ksu
 */

@Entity
@Table(name="hobbies")
public class MappedHobby {
    
    @Id  
    @Column(name = "HOBBY_ID")  
    @GeneratedValue  
    private long hobbyID;
    
    @Column(name="HOBBY_NAME", length=100, nullable=false)
    private Hobby hobbyName;
}
