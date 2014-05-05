package cn.edu.sdu.b2cshop.core.events.eventbus;

import play.Logger;
import cn.edu.sdu.b2cshop.core.events.Event;
import cn.edu.sdu.b2cshop.core.spring.ApplicationContextUtils;

public class EventBus {

    public static void publish(Event event) {
        Logger.debug("EventBus.publish");
        Logger.debug("  event: " + event);

        ApplicationContextUtils.getContext().publishEvent(event);
    }

}
