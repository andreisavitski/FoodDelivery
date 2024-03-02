package by.pvt.fooddelivery.constant;

import java.math.BigDecimal;

public class AppConstants {
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
    public static final String SELECT_ORDER_FOR_DELIVERY = "select";
    public static final String COMPLETE_THE_ORDER_FOR_DELIVERY = "complete";
    public static final String REFUSAL_TO_DELIVERY_ORDER = "refusal";
    public static final Long NAMELESS_COURIER = 1L;
    public static final String BEARER_PREFIX = "Bearer ";
    public static final String HEADER_NAME = "Authorization";
    public static final String TOKEN_KEY = "${token.signing.key}";
    public static final String ID = "id";
    public static final String LOGIN = "login";
    public static final String EMAIL = "email";
    public static final String ROLE = "role";
    public static final Long TOKEN_VALIDITY_DURATION_MILLIS = 100000L * 60L * 24L;
    public static final String SEQUENCE_GENERATOR = "seq";
}
