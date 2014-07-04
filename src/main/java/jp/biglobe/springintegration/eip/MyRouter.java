package jp.biglobe.springintegration.eip;

import org.springframework.integration.annotation.Headers;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.annotation.Splitter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sane on 2014/07/01.
 */
@Component
public class MyRouter {

    @Router
    public String route(String message) {

        if (message.startsWith("Facebook")) {
            System.out.println("##route: channelFacebook");
            return "channelFacebook";
        }
        if (message.startsWith("Twitter")) {
            System.out.println("##route: channelTwitter");
            return "channelTwitter";
        }
        if (message.startsWith("Instagram")) {
            System.out.println("##route: channelInstagram");
            return "channelInstagram";
        }
        throw new RuntimeException("##no hit");
    }
}
