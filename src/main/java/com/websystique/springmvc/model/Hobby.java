/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.model;

import com.websystique.springmvc.entity.MappedHobby;

/**
 *
 * @author ksu
 */
public class Hobby {
    
    private String hobbyName;

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }
    
    Hobby (MappedHobby mappedHobby) {
        this.hobbyName=mappedHobby.getHobbyName();
    }
}
