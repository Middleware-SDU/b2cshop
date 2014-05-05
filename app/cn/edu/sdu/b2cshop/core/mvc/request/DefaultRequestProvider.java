package cn.edu.sdu.b2cshop.core.mvc.request;

import java.util.List;
import java.util.Map;

import play.Play;
import play.api.http.MediaRange;
import play.i18n.Lang;
import play.mvc.Http.Request;
import play.mvc.Http.RequestBody;

public class DefaultRequestProvider extends AbstractRequestProvider {

    @Override
    protected Request create() {
        final String host = Play.application().configuration().getString("application.host", "localhost");
        final int port = Play.application().configuration().getInt("application.port", 9000);

        return new Request() {
            @Override
            public RequestBody body() {
                throw new UnsupportedOperationException();
            }

            @Override
            @Deprecated
            public List<String> accept() {
                throw new UnsupportedOperationException();
            }

            @Override
            public List<Lang> acceptLanguages() {
                throw new UnsupportedOperationException();
            }

            @Override
            public List<MediaRange> acceptedTypes() {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean accepts(String arg0) {
                throw new UnsupportedOperationException();
            }

            @Override
            public play.mvc.Http.Cookies cookies() {
                throw new UnsupportedOperationException();
            }

            @Override
            public Map<String, String[]> headers() {
                throw new UnsupportedOperationException();
            }

            @Override
            public String host() {
                if (port == 80) {
                    return host;
                } else {
                    return host + ":" + port;
                }
            }

            @Override
            public String method() {
                throw new UnsupportedOperationException();
            }

            @Override
            public String path() {
                throw new UnsupportedOperationException();
            }

            @Override
            public Map<String, String[]> queryString() {
                throw new UnsupportedOperationException();
            }

            @Override
            public String remoteAddress() {
                throw new UnsupportedOperationException();
            }

            @Override
            public String uri() {
                throw new UnsupportedOperationException();
            }

            @Override
            public String version() {
                throw new UnsupportedOperationException();
            }
        };
    }

}
