package cn.edu.sdu.b2cshop.core.events.handlers;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

public abstract class AbstractEventHandler<E extends ApplicationEvent> implements ApplicationListener<E>, Ordered {

    public void onApplicationEvent(E event) {
        this.execute(event);
    }

    protected abstract void execute(E event);

    @Override
    public int getOrder() {
        return 0;
    }

}
