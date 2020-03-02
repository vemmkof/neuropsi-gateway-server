package mx.ipn.escom.neuropsigatewayserver.config;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreZuulFilter extends ZuulFilter {


  private static final Logger log = LoggerFactory.getLogger(PreZuulFilter.class);

  @Override
  public boolean shouldFilter() {
    final RequestContext requestContext = RequestContext.getCurrentContext();
    HttpServletRequest httpServletRequest = requestContext.getRequest();
    String requestUri = httpServletRequest.getRequestURI();
    log.info("Request URI: " + requestUri);
    return !requestUri.startsWith("/auth/oauth/token");
  }

  @Override
  public Object run() throws ZuulException {
    final RequestContext requestContext = RequestContext.getCurrentContext();
    requestContext.put("userRole", "ADMINISTRATOR");
    log.info(requestContext.toString());
    return null;
  }

  @Override
  public String filterType() {
    return FilterConstants.PRE_TYPE;
  }

  @Override
  public int filterOrder() {
    return FilterConstants.PRE_DECORATION_FILTER_ORDER - 3;
  }

}
