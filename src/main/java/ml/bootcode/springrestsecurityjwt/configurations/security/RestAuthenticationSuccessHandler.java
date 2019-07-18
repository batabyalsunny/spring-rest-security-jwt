/**
 * 
 */
package ml.bootcode.springrestsecurityjwt.configurations.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sunnyb
 *
 */
//@Configuration
public class RestAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private final ObjectMapper mapper;

	@Autowired
	public RestAuthenticationSuccessHandler(MappingJackson2HttpMessageConverter messageConverter) {
		this.mapper = messageConverter.getObjectMapper();
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_OK);
	}
}
