import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import controller.PlaceOrderController;

public class ValidateName {

	private PlaceOrderController placeOrderController;
	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	
	@ParameterizedTest
	@CsvSource({
		"'', false",
		", false",
		"'Doan Ngoc Kh@nh', false",
		"'3 Khanh', false",
		"'Doan Ngoc Khanh', true",
		"'Đoàn Ngọc Khánh', true"
	})


	public void test(String name, boolean expected) {
		// when
		boolean isValid = placeOrderController.validateName(name);
		//then
		assertEquals(expected, isValid);
	}

}
