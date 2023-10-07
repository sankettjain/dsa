package com.pratice.dsa.interview.splitwise;

import lombok.Data;

import java.util.List;

@Data
public class Group {

    private String name;
    private String description;
    private List<User> userList;
    private List<Expense> expenseList;

}
