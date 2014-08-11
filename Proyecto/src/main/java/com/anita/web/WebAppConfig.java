package com.anita.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author A-n-I-t-A
 */
@EnableWebMvc
@Configuration
@ComponentScan("com.castillo.fin")
public class WebAppConfig extends WebMvcConfigurerAdapter {
    
}