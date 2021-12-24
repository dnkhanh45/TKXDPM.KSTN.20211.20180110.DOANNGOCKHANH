package controller;

import controller.interfaces.DeliveryDayValidatorInterface;

import java.util.Date;
import java.text.SimpleDateFormat;
import javafx.util.Pair;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class SimpleDeliveryDayValidator implements DeliveryDayValidatorInterface{
    public Pair<Boolean, Date> validateExpectedTime(String expectedTime) {
        if ((expectedTime == null) || (expectedTime.isEmpty())) {
    		return new Pair<Boolean, Date>(false, null);
    	}
    	String[] patterns = {"yyyy-MM-dd HH", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH:mm:SS"};
    	Date expectedDate = null;
    	for (String pattern : patterns) {
    	    try {
    	    	SimpleDateFormat format = new SimpleDateFormat(pattern);
    	    	expectedDate = format.parse(expectedTime);
    	        break; //if your date is correct break your look
    	    } catch (ParseException e) {}
    	}
    	if (expectedDate == null) {
    		return new Pair<Boolean, Date>(false, null);
    	}
    	return new Pair<Boolean, Date>(true, expectedDate);
    }
    
    /**
     * Kiem tra thoi gian giao hang nhanh co thuoc khoang 0 den 10 ngay
     * @param expectedDate
     * @return
     */
    public boolean validateRushTimeDiff(Date expectedDate) {
    	long milliesSecondDiff = Math.abs(expectedDate.getTime() - new Date().getTime());
    	long dateDiff = TimeUnit.DAYS.toDays(milliesSecondDiff);
    	if ((dateDiff < 0) || (dateDiff > 10)) {
    		return false;
    	}
    	return true;
    }
}
