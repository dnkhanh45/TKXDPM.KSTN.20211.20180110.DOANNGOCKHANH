package controller.interfaces;
import java.util.Date;
import javafx.util.Pair;

public interface DeliveryDayValidatorInterface {
    public boolean validateRushTimeDiff(Date expectedDate);
    public Pair<Boolean, Date> validateExpectedTime(String expectedTime);
}
