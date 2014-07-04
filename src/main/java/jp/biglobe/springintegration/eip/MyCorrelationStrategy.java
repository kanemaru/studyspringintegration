package jp.biglobe.springintegration.eip;

import org.springframework.integration.aggregator.CorrelationStrategy;
import org.springframework.messaging.Message;

public class MyCorrelationStrategy implements CorrelationStrategy {

    public Object getCorrelationKey(Message<?> message) {
        String payload = (String) message.getPayload();
        String num = payload.substring(payload.length() - 3);
        return num;
    }
}
