package cn.edu.sdu.b2cshop.core.mvc.request;

import play.Play;
import play.mvc.Http.Context;
import play.mvc.Http.Request;

/**
 * {@link Request} provider where an http request might not exist.
 * <p>
 * By default, it provides an instance of {@link Request} with <code>application.host</code> and <code>application.port</code> in application.conf.
 * 
 * @author Peter Fu
 * @see DefaultRequestProvider
 */
public class RequestProvider {

    static final String DEFAULT_PROVIDER = "com.kernelogic.process6.core.mvc.request.DefaultRequestProvider";
    static IRequestProvider provider = null;

    public static Request get() {
        // Return current HTTP request if exists
        Context context = Context.current.get();
        if (context != null) {
            return context.request();
        }

        // Otherwise create a dummy one instead
        if (provider == null) {
            provider = createProvider();
        }
        return provider.get();
    }

    static IRequestProvider createProvider() {
        String className = Play.application().configuration().getString("application.akka.request_header_provider", DEFAULT_PROVIDER);
        Class<?> clazz;
        try {
            clazz = Play.application().classloader().loadClass(className);
            provider = (IRequestProvider) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return provider;
    }

}
