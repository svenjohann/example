package de.example.domain1.web;

import de.example.domain1.model.Greeting;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DemoController {

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
}
