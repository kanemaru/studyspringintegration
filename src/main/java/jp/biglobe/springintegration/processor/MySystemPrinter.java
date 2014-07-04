package jp.biglobe.springintegration.processor;

import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by sane on 2014/07/01.
 */
@Component
public class MySystemPrinter {
    public void process(Object order) {
        System.out.println(order);
    }
}
