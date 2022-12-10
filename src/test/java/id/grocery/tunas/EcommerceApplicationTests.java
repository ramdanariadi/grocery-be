package id.grocery.tunas;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;


class EcommerceApplicationTests {

	Calculator calculator = new Calculator();

	@Test
	void isShouldAddNumber() {
		// given number
		Integer a = 1;
		Integer b = 2;

		// when
		Integer result = calculator.add(a,b);

		// then
		assertThat(result).isEqualTo(3);
	}

	class Calculator{
		Integer add(Integer a, Integer b) {
			return a + b;
		}
	}

}
