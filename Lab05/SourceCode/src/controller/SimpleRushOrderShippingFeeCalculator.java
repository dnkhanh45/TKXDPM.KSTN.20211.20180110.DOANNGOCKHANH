package controller;

import java.util.HashMap;

import controller.interfaces.RushOrderShippingFeeCalculatorInterface;

public class SimpleRushOrderShippingFeeCalculator implements RushOrderShippingFeeCalculatorInterface{
    public long shippingRushFeeCalculate(String directory) {
        HashMap<String, Long> feeDict = new HashMap<>();
        return feeDict.get(directory);
    }
}
