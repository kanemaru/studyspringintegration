package jp.biglobe.springintegration.processor;

import org.springframework.stereotype.Component;

/**
 * Created by sane on 2014/07/01.
 */
@Component
public class MyFacebookProcessor {
    public String process(String payload) {
        String num = payload.substring(payload.length() - 3);
        return payload + " MyFacebookProcessor process done!! " + num;
    }
}
