package com.rs.retrofit.playground.controller;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller
public class BasicController {

    @Get("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello there!";
    }

    @Get("/hi")
    @Produces(MediaType.TEXT_PLAIN)
    public String hi(@Parameter String name) {
        return "Hi there, " + name;
    }
}
