/**
 *
 */
package ml.bootcode.springrestsecurityjwt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunnybatabyal
 *
 */
@RestController
public class MainController {

	@GetMapping
	public String sayHello() {
		return "Hello";
	}

	@GetMapping("view")
	public String view() {
		return "Viewed";
	}

	@GetMapping("download")
	public String download() {
		return "Downloaded";
	}

	@GetMapping("edit")
	public String edit() {
		return "Edited";
	}
}
