package jp.biglobe.springintegration.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String indexAction(@RequestParam(value = "message", required=false) String message, ModelMap model) throws Exception {

        // DIコンテナの起動
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/spring-integration-context.xml");
        context.start();

        // channel1を取得
        MessageChannel channelStartOut = (MessageChannel) context.getBean("channelStart");

        if (message == null) {
            message = "default";
        }
        String buildMessage = "Hello " + message + " !!!";

        // オブジェクトを送信
        channelStartOut.send(MessageBuilder.withPayload(buildMessage).build());

        return "index";
    }
}