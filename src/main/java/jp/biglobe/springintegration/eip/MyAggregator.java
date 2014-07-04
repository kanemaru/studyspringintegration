package jp.biglobe.springintegration.eip;

import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.Router;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sane on 2014/07/01.
 */
@Component
public class MyAggregator {

    @Aggregator
    public String aggregateMessage(List<String> message) {

        StringBuilder builder = new StringBuilder();

        boolean isFirst = true;
        for (String line : message) {
            if (!isFirst) {
                builder.append(", ");
            }
            builder.append(line);
            isFirst = false;
        }
        return builder.toString();
    }
}
