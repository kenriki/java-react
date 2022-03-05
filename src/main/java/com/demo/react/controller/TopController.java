package com.demo.react.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopController {
  @GetMapping("/")
  public String any() {
    return "forward:/index";
  }
}