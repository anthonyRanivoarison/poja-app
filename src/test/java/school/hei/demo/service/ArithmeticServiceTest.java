package school.hei.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.hei.demo.model.ArithmeticResult;

class ArithmeticServiceTest {

  ArithmeticService subject;

  @BeforeEach
  void setUp() {
    subject = new ArithmeticService();
  }

  @Test
  void add_returns_sum() {
    ArithmeticResult result = subject.add(10.0, 5.0);
    assertEquals("add", result.getOperation());
    assertEquals(15.0, result.getResult());
  }

  @Test
  void subtract_returns_difference() {
    ArithmeticResult result = subject.subtract(10.0, 5.0);
    assertEquals("subtract", result.getOperation());
    assertEquals(5.0, result.getResult());
  }

  @Test
  void multiply_returns_product() {
    ArithmeticResult result = subject.multiply(4.0, 3.0);
    assertEquals("multiply", result.getOperation());
    assertEquals(12.0, result.getResult());
  }

  @Test
  void divide_returns_quotient() {
    ArithmeticResult result = subject.divide(10.0, 2.0);
    assertEquals("divide", result.getOperation());
    assertEquals(5.0, result.getResult());
  }

  @Test
  void divide_by_zero_throws() {
    assertThrows(ArithmeticException.class, () -> subject.divide(10.0, 0.0));
  }
}
