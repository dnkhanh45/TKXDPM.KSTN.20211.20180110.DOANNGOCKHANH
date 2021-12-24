import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import controller.PlaceOrderController;

class ValidateAddressTest {

	private PlaceOrderController placeOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	
	@ParameterizedTest
	@CsvSource({
		", false",
		"'', false",
		"'#12 Khâm Thiên', false",
		"'12 Khâm Thiên', true"
	})

	
	void test(String address, boolean expected) {
		// when
		boolean isValid = placeOrderController.validateAddress(address);
		//then
		assertEquals(expected, isValid);
	}

}