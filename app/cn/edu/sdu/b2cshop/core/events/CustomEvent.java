package cn.edu.sdu.b2cshop.core.events;

public class CustomEvent extends Event {

    private static final long serialVersionUID = -705091459097198288L;

    private String type;

    public CustomEvent(String type, String sourceType, Object source) {
        super(sourceType, source);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
