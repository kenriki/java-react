package com.demo.react.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping("/greeting") // HTTP GET/POST/PUT/PATCH/DELETE などすべてマッピングされます。
    // @RequestMapping(path = "/greeting", method = RequestMethod.GET) // GET だけをマッピングする場合の記法
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        // `src/main/resources/templates/` 内の View ファイル名を指定します。
        // メソッド名や `@RequestMapping` で指定したパス名と一致する必要はありません。
        return "greeting";
    }
}