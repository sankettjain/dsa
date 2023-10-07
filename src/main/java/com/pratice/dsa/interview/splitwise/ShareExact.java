package com.pratice.dsa.interview.splitwise;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShareExact implements ShareLogic {

    private Double amount;


    @Override
    public double getAmount() {
        return amount;
    }
}
