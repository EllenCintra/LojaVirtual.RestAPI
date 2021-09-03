package com.github.ericomonteiro.smartstock.config.error;

public class ErrorKeys {

    public static class General {
        public static final String NOT_FOUND = "general-404";
        public static final String INTERNAL_SERVER_ERROR = "general-500";
        public static final String ACCESS_DENIED = "general-401";
    }

    public static class Product {
        public static final String NAME_NOT_BLANK = "product-1";
        public static final String DETAIL_NOT_BLANK = "product-2";
        public static final String PRICE_MUST_GREATER_ZERO = "product-3";
        public static final String PRICE_NOT_NULL = "product-4";
        public static final String ALREADY_PRODUCT_WITH_THIS_NAME = "product-5";

        public static class Album {
            public static final String MAIN_PHOTO_UNDEFINED = "product-album-1";
        }
    }

    public static class Stock {
        public static final String STOCK_IS_NOT_ENOUGH = "stock-1";
    }

}
