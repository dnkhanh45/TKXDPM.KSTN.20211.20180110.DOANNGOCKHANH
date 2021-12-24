package controller;

import controller.interfaces.RushOrderAmountCalculatorInterface;
import entity.order.Order;

public class SimpleRushOrderAmountCalculator implements RushOrderAmountCalculatorInterface{
    public long rushOrderAmountCalulate(Order order) {
        return order.getAmount();
    }
}
