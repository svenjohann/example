package de.example.domain1.web;

import de.example.domain1.model.Greeting;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
import static org.springframework.http.HttpStatus.OK;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private String url;

	@Before
	public void setUp() throws Exception {
		url = "http://localhost:" + port + "/greeting";
	}

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		String response = this.restTemplate.getForObject(url + "?name=Sven", String.class);
		assertThat(response).contains("Hello, Sven");
	}

	@Test
	public void postHelenaGreetingIsAllowed() throws Exception {
		ResponseEntity<String> response = restTemplate
				.exchange(url, HttpMethod.POST, createEntity("Helena"), String.class);

		assertEquals(OK, response.getStatusCode());
	}

	@Test
	public void postSvenGreetingIsNotAllowed() throws Exception {
		ResponseEntity<String> response = restTemplate
				.exchange(url, HttpMethod.POST, createEntity("Sven"), String.class);

		assertEquals(UNPROCESSABLE_ENTITY, response.getStatusCode());
		assertEquals("Sven darf man nicht grüßen", response.getBody());
	}

	private HttpEntity<Greeting> createEntity(String msg) {
		Greeting greeting = new Greeting(msg);
		return new HttpEntity<>(greeting);
	}
}
