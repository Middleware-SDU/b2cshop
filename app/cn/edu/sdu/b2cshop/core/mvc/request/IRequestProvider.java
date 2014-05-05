package cn.edu.sdu.b2cshop.core.mvc.request;

import play.mvc.Http.Request;

/**
 * Interface of {@link Request} providers
 * 
 * Usage:
 * <ul>
 * <li>1. Create your custom provider implementing this interface
 * <li>2. Add <code>application.akka.request-provider=${full_qualified_class_name}</code> of your custom provider to application.conf
 * </ul>
 * 
 * @author Peter Fu
 */
public interface IRequestProvider {

    Request get();

}
