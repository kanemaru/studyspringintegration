package jp.biglobe.springintegration.eip;

import org.springframework.integration.annotation.Headers;
import org.springframework.integration.annotation.Splitter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by sane on 2014/07/01.
 */
@Component
public class MySplitter {

    @Splitter
    public List splitMessage(String payload, @Headers Map headers) {

        String id = String.valueOf(new Random().nextInt(10));

        List result = new ArrayList<String>();
        result.add("Facebook " + payload + " (" + id + ")");
        result.add("Twitter " + payload + " (" + id + ")");
        result.add("Instagram " + payload + " (" + id + ")");
        System.out.println("##Splitter: " + id);
        return result;
    }
}
