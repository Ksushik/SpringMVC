/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websystique.springmvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author ksu
 */

@Configuration
@ComponentScan({
    "com.websystique.springmvc.dao", 
    "com.websystique.springmvc.service",
    "com.websystique.springmvc.configuration",
    "com.websystique.springmvc.controllers"
})
@EnableTransactionManagement
@PropertySource({"classpath:ContactBookMaximumSize.properties","classpath:contacts.properties"})
@Import({MVCConfig.class,HibernateConfiguration.class})
public class AppConfig {
    
}
