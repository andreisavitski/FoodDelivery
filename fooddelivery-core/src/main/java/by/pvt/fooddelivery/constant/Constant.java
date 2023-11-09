package by.pvt.fooddelivery.constant;

import java.math.BigDecimal;

public class Constant {
    /**
     * a digit must occur at least once
     * a lower case letter must occur at least once
     * an upper case letter must occur at least once
     * a special character must occur at least once
     * no whitespace allowed in the entire string
     * anything, at least eight places though
     * end-of-string
     */
    public static final String PASSWORD_VALIDATION = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    public static final String PHONE_NUMBER_VALIDATION = "^(\\+375|375|\\+80|80)?[\\s\\-]?(29|44|33|25)?[\\s\\-]?[0-9]{3}?[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}$";
    public static final BigDecimal SERVICE_FEE = new BigDecimal(1);
    public static final BigDecimal COST_OF_DELIVERY = new BigDecimal(3);
    public static final BigDecimal FREE_DELIVERY_CONDITION = new BigDecimal(100);
    public static final BigDecimal FREE_DELIVERY = new BigDecimal(0);
    public static final String DELETE_PRODUCT_ORDER = "delete";
    public static final String ADD_PRODUCT_ORDER = "add";
}
