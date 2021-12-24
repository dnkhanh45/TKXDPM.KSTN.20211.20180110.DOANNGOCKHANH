package controller;

import controller.interfaces.DeliveryDayValidatorInterface;
import controller.interfaces.RushOrderAmountCalculatorInterface;
import controller.interfaces.RushOrderShippingFeeCalculatorInterface;
import entity.order.Order;

public class PlaceRushOrderController {
    private DeliveryDayValidatorInterface deliveryDayValidator;
    private RushOrderAmountCalculatorInterface amountCalculator;
    private RushOrderShippingFeeCalculatorInterface shippingFeeCalculator;

    public boolean validateDeliveryDay(String expectedTime) {
        return this.deliveryDayValidator.validateExpectedTime(expectedTime).getKey();
    }

    public long getAmount(Order order) {
        return this.amountCalculator.rushOrderAmountCalulate(order);
    }

    public long getFee(String directory) {
        return this.shippingFeeCalculator.shippingRushFeeCalculate(directory);
    }
}
