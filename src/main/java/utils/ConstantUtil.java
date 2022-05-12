package utils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ConstantUtil {

    public static final String LOGIN_PAGE_TITLE = "Account Login";
    public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";
    public static final String ACCOUNT_PAGE_TITLE = "My Account";
    public static final List<String> EXPECTED_ACCOUNT_SECTION_LIST = Arrays.asList("My Account",
                                                                                    "My Orders",
                                                                                    "My Affiliate Account",
                                                                                    "Newsletter");
    public static final int DEFAULT_WAIT_TIME = 5;
    public static final String SEARCH_STRING = "MACBOOK";
    public static final int PRODUCT_LIST_SIZE = 3;
    public static final String SUCCESS_MSG = "Your Account Has Been Created!";
    public static final String EXCEL_SHEET_PATH = "C:\\Users\\user\\IdeaProjects\\HybridFrameworkCreation\\src\\test\\resources\\testData\\ExcelDataProvider.xlsx";
    public static final String EXCEL_SHEET_NAME = "register";
}
