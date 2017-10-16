package de.dpd.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@SpringBootApplication
@RestController
public class DemoApplication {

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(String.format("Hello, %s!", name));
	}

	@PostMapping("/greeting")
	public String postGreeting(@Valid @RequestBody Greeting greeting, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException(bindingResult);
		}
		return "OK";
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemoApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
