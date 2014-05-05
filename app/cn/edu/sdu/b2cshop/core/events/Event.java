package cn.edu.sdu.b2cshop.core.events;

import org.springframework.context.ApplicationEvent;

public class Event extends ApplicationEvent {

    private static final long serialVersionUID = 2335046835664273986L;

    private String sourceType;

    public Event(String sourceType, Object source) {
        super(source);
        this.sourceType = sourceType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[sourceType=" + sourceType + ",source=" + source + "]";
    }

}
