package day01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HelloTest {

	@Test
	void cas01() {
		// Arrange
		Hello hello = new Hello();
		// Act
		String actureResult=hello.sayHi("apiwat");
		// Assert
		assertEquals("Hello, apiwat",actureResult);
	}

}
