import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import controller.PlaceOrderController;

public class ValidateExpectedTime {

	private PlaceOrderController placeOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	
	@ParameterizedTest
	@CsvSource({
		"'', false",
		", false",
		"'20-a4-3', false",
		"'2020-12-03 20', true",
		"'2020-12-03 20:15', true",
		"'2020-12-03 20:15:30', true"
	})


	public void test(String expectedTime, boolean expected) {
		// when
		boolean isValid = placeOrderController.validateExpectedTime(expectedTime).getKey();
		//then
		assertEquals(expected, isValid);
	}

}
