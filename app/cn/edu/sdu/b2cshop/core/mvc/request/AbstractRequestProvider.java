package cn.edu.sdu.b2cshop.core.mvc.request;

import play.mvc.Http.Request;

public abstract class AbstractRequestProvider implements IRequestProvider {

    protected Request request = null;

    @Override
    public Request get() {
        if (request == null) {
            request = create();
        }

        return request;
    }

    protected abstract Request create();

}
