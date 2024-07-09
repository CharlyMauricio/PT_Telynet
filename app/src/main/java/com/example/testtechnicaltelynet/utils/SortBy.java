package com.example.testtechnicaltelynet.utils;

import com.example.testtechnicaltelynet.data.Customer;

import java.util.Comparator;

public class SortBy {

    public static class Name implements Comparator<Customer> {
        public int compare(Customer customer1, Customer customer2) {
            return customer1.getName().compareTo(customer2.getName());
        }
    }
    public static class Code implements Comparator<Customer> {
        public int compare(Customer customer1, Customer customer2) {
            return Integer.compare(customer1.getCode(), customer2.getCode());
        }
    }

}