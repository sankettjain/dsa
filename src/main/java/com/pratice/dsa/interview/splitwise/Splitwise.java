package com.pratice.dsa.interview.splitwise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Splitwise {


    Map<String, Map<String, Double>> userToOwedMoneyMap = new HashMap<>();

    public void shareTheExpense(Expense expense, String type) {

        ShareLogic shareLogic;

        if ("EQUALLY".equals(type)) {
            shareLogic = new ShareEqually(expense.getAmount(), expense.getSplitBetween().size());
            double amount = shareLogic.getAmount();
            for (User user : expense.getSplitBetween()) {
                if (userToOwedMoneyMap.containsKey(expense.getPaidBy().getName())) {
                    Map<String, Double> ownedMoneyMap = userToOwedMoneyMap.get(expense.getPaidBy().getName());
                    ownedMoneyMap.put(user.getName(), ownedMoneyMap.getOrDefault(user.getName(), 0.0) + amount);
                    userToOwedMoneyMap.put(expense.getPaidBy().getName(), ownedMoneyMap);
                } else {
                    Map<String, Double> ownedMoney = new HashMap<>();
                    ownedMoney.put(user.getName(), amount);
                    userToOwedMoneyMap.put(expense.getPaidBy().getName(), ownedMoney);
                }
            }
        } else if("EXACT".equals(type)){
            shareLogic = new ShareExact(expense.getAmount());
            double amount = shareLogic.getAmount();
            for (User user : expense.getSplitBetween()) {
                if (userToOwedMoneyMap.containsKey(expense.getPaidBy().getName())) {
                    Map<String, Double> ownedMoneyMap = userToOwedMoneyMap.get(expense.getPaidBy().getName());
                    ownedMoneyMap.put(user.getName(), ownedMoneyMap.getOrDefault(user.getName(), 0.0) + amount);
                    userToOwedMoneyMap.put(expense.getPaidBy().getName(), ownedMoneyMap);
                } else {
                    Map<String, Double> ownedMoney = new HashMap<>();
                    ownedMoney.put(user.getName(), amount);
                    userToOwedMoneyMap.put(expense.getPaidBy().getName(), ownedMoney);
                }
            }
        }
    }

    public void summary(String name) {
        System.out.println("Current Summary for user: "+name+" -> " + userToOwedMoneyMap.getOrDefault(name, null));
    }


    public static void main(String[] args) {

        User u1 = new User("Sam", "sam@gmail.com");
        User u2 = new User("Pam", "pam@gmail.com");
        User u3 = new User("Nam", "nam@gmail.com");
        User u4 = new User("Tam", "tam@gmail.com");

        Splitwise splitwise = new Splitwise();

        Expense expense = new Expense(100.0, u1, "Tea", Arrays.asList(u2, u3, u4));
        splitwise.shareTheExpense(expense, "EQUALLY");
        splitwise.summary(u1.getName());

        Expense expense1 = new Expense(2000.0, u1, "Tea", Arrays.asList(u2));
        splitwise.shareTheExpense(expense1, "EXACT");
        splitwise.summary(u1.getName());

    }
}
