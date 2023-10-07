package com.pratice.dsa.interview.splitwise;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Expense {

    private Double amount;
    private User paidBy;
    private String name;
    private List<User> splitBetween;


}
