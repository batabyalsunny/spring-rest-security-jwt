/**
 * 
 */
package ml.bootcode.springrestsecurityjwt.dtos;

/**
 * @author sunnyb
 *
 */
public class LoginResponseDto {

	private String token;

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
}
