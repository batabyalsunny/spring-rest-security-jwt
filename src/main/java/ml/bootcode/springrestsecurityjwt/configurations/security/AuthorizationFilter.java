/**
 * 
 */
package ml.bootcode.springrestsecurityjwt.configurations.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

/**
 * @author sunnyb
 *
 */
@Component
public class AuthorizationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String token = req.getHeader("token");

		if (!token.equals("authToken")) {
			throw new BadCredentialsException("Invalid Token");
		}

		chain.doFilter(request, response);
	}

}
