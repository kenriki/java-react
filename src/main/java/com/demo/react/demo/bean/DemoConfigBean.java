package com.demo.react.demo.bean;

import java.util.Collections;

import javax.servlet.SessionTrackingMode;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfigBean {

  /**
   * 初回アクセス時に、URLにjsessionidが付与されるのを防ぐためのBean定義
   *
   * @return ServletContextInitializerオブジェクト
   */
  @Bean
  public ServletContextInitializer servletContextInitializer() {
    final ServletContextInitializer initializer = servletContext -> {
      servletContext.setSessionTrackingModes(Collections.singleton(SessionTrackingMode.COOKIE));
    };
    return initializer;
  }
}
