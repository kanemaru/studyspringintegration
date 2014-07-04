package jp.biglobe.springintegration.eip;

import org.springframework.integration.aggregator.ReleaseStrategy;
import org.springframework.integration.store.MessageGroup;

public class MyReleaseStrategy implements ReleaseStrategy {

    public boolean canRelease(MessageGroup group) {
        if (group.getMessages().size() >= 3) {
            return true;
        }
        return false;
    }
}
