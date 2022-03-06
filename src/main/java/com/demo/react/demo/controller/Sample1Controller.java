package com.demo.react.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Sample1Controller {

  /**
   * 初期表示画面に遷移する
   *
   * @return 初期表示画面
   */
  @RequestMapping(value = "/sample1", method = RequestMethod.GET)
  public String index() {
    return "sample1";
  }

  /**
   * フォワードでsample_result画面に遷移する
   *
   * @param model Modelオブジェクト
   * @return sample_result画面
   */
  @RequestMapping(value = "/toForward", method = RequestMethod.POST)
  public String toForward(Model model) {
    // sample_result画面に渡す値を設定する
    // フォワード遷移する場合はModelオブジェクトに値を設定する
    model.addAttribute("pushedBtn", "フォワード遷移ボタン");

    // フォワードでsample_result画面に遷移する
    // このとき、リダイレクト遷移先はPOSTメソッドのままとする
    return "forward:/toMainPost";
  }

  /**
   * 初期表示画面に戻る
   *
   * @return 初期表示画面
   */
  @RequestMapping(value = "/sample1", method = RequestMethod.POST)
  public String toIndex() {
    return "sample1";
  }

  /**
   * sample_result画面にGETメソッドで遷移する
   *
   * @param model Modelオブジェクト
   * @return sample_result画面
   */
  @RequestMapping(value = "/toMainGet", method = RequestMethod.GET)
  public String toMainGet(Model model) {
    model.addAttribute("passedMethod", "toMainGetメソッド");
    return "sample_result";
  }

  /**
   * sample_result画面にPOSTメソッドで遷移する
   *
   * @param model Modelオブジェクト
   * @return sample_result画面
   */
  @RequestMapping(value = "/toMainPost", method = RequestMethod.POST)
  public String toMainPost(Model model) {
    model.addAttribute("passedMethod", "toMainPostメソッド");
    return "sample_result";
  }

  /**
   * リダイレクトでsample_result画面に遷移する
   *
   * @param redirectAttributes リダイレクト属性値
   * @return sample_result画面
   */
  @RequestMapping(value = "/toRedirect", method = RequestMethod.POST)
  public String toRedirect(RedirectAttributes redirectAttributes) {
    // sample_result画面に渡す値を設定する
    // リダイレクト遷移する場合はFlash Scopeを利用する
    redirectAttributes.addFlashAttribute("pushedBtn", "リダイレクト遷移ボタン");

    // リダイレクトでsample_result画面に遷移する
    // このとき、リダイレクト遷移先はGETメソッドとする
    return "redirect:/toMainGet";
  }
}
