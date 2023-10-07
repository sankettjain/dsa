package com.pratice.dsa.interview.splitwise;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShareEqually implements ShareLogic {

    private double amount;
    private int splitCount;

    @Override
    public double getAmount() {
        return amount / splitCount;
    }
}
