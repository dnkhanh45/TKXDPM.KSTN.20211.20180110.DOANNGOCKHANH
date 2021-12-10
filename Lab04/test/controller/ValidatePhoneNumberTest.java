import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import controller.PlaceOrderController;

class ValidatePhoneNumberTest {

	private PlaceOrderController placeOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	
	@ParameterizedTest
	@CsvSource({
		"'123456789', false",
		"'122343acd43', false",
		"'123445456575443', false",
		"'', false",
		", false",
		"'012ắ234235', false",
		"'0123456789', true"
	})


	public void test(String phoneNumber, boolean expected) {
		// when
		boolean isValid = placeOrderController.validatePhoneNumber(phoneNumber);
		//then
		assertEquals(expected, isValid);
	}

}
