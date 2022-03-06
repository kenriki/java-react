package com.demo.react.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TopController {
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {
    model.addAttribute("link_message", "youtube"); //表示するテキストを設定
    model.addAttribute("url", "https://www.youtube.com/");
    return "index";
  }
}