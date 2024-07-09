package com.example.testtechnicaltelynet.utils;

import com.example.testtechnicaltelynet.data.Customer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DataListCustomersMock {

    private static final Integer TOTAL_CUSTOMERS_MOCK = 25;
    private static final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String randomIdentifier() {
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();
        Set<String> identifiers = new HashSet<>();
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    private static Integer randomId() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    public static List<Customer> customerList() {
        List<Customer> dataList = new ArrayList<>();


        for (int i = 0; i < TOTAL_CUSTOMERS_MOCK; i++) {
            boolean isVisited = false;
            Customer customer = new Customer();
            customer.setCode(randomId());
            customer.setName("Cliente ".concat(randomIdentifier()));
            customer.setPhone("551081357".concat(String.valueOf(i)));
            customer.setEmail("email".concat(String.valueOf(i)).concat("@gmail.com"));
            if (i % 2 == 0) {
                isVisited = true;
            }
            customer.setVisited(isVisited);

            dataList.add(customer);
        }

        return dataList;
    }
}
