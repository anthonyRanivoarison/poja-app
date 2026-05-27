package school.hei.demo.endpoint.rest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import school.hei.demo.model.ArithmeticResult;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArithmeticControllerTest {

  @Autowired TestRestTemplate restTemplate;

  @Test
  void add_returns_sum() {
    ResponseEntity<ArithmeticResult> response =
        restTemplate.getForEntity("/arithmetic/add?a=10&b=5", ArithmeticResult.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("add", response.getBody().getOperation());
    assertEquals(15.0, response.getBody().getResult());
  }

  @Test
  void subtract_returns_difference() {
    ResponseEntity<ArithmeticResult> response =
        restTemplate.getForEntity("/arithmetic/subtract?a=10&b=5", ArithmeticResult.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("subtract", response.getBody().getOperation());
    assertEquals(5.0, response.getBody().getResult());
  }

  @Test
  void multiply_returns_product() {
    ResponseEntity<ArithmeticResult> response =
        restTemplate.getForEntity("/arithmetic/multiply?a=4&b=3", ArithmeticResult.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("multiply", response.getBody().getOperation());
    assertEquals(12.0, response.getBody().getResult());
  }

  @Test
  void divide_returns_quotient() {
    ResponseEntity<ArithmeticResult> response =
        restTemplate.getForEntity("/arithmetic/divide?a=10&b=2", ArithmeticResult.class);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("divide", response.getBody().getOperation());
    assertEquals(5.0, response.getBody().getResult());
  }

  @Test
  void divide_by_zero_returns_error() {
    ResponseEntity<String> response =
        restTemplate.getForEntity("/arithmetic/divide?a=10&b=0", String.class);
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    assertTrue(response.getBody().contains("Internal Server Error"));
  }
}
