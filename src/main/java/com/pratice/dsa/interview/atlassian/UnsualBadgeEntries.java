package com.pratice.dsa.interview.atlassian;

import java.util.*;

public class UnsualBadgeEntries {


    public static void main(String[] args) throws Exception {


        String[][]
                badge_times = {
                {"Paul", "1355"}, {"Jennifer", "1910"}, {"Jose", "835"},
                {"Jose", "830"}, {"Paul", "1315"}, {"Chloe", "0"},
                {"Chloe", "1910"}, {"Jose", "1615"}, {"Jose", "1640"},
                {"Paul", "1405"}, {"Jose", "855"}, {"Jose", "930"},
                {"Jose", "915"}, {"Jose", "730"}, {"Jose", "940"},
                {"Jennifer", "1335"}, {"Jennifer", "730"}, {"Jose", "1630"},
                {"Jennifer", "5"}, {"Chloe", "1909"}, {"Zhang", "1"},
                {"Zhang", "10"}, {"Zhang", "109"}, {"Zhang", "110"},
                {"Amos", "1"}, {"Amos", "2"}, {"Amos", "400"},
                {"Amos", "500"}, {"Amos", "503"}, {"Amos", "504"},
                {"Amos", "601"}, {"Amos", "602"}, {"Paul", "1416"}
        };

        System.out.println(findUnusualBadges(badge_times));

    }

    private static Collection<String> findUnusualBadges(String[][] badge_times) throws Exception {

        Map<String, List<Integer>> userToEntries = new HashMap<>();

        for (String[] badgeTime : badge_times) {

            String name = badgeTime[0];
            Integer time = convertToMinutes(badgeTime[1]);

            if (!userToEntries.containsKey(name)) {
                userToEntries.put(name, new ArrayList<>());
            }
            userToEntries.get(name).add(time);

        }


        Map<String, String> userData = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : userToEntries.entrySet()) {

            String name = entry.getKey();
            List<Integer> entries = entry.getValue();


            if (!userData.containsKey(name)) {
                Collections.sort(entries, (o1, o2) -> o1 - o2);

                for (int i = 0; i < entries.size() - 2; i++) {

                    int time = entries.get(i);
                    int time1 = entries.get(i + 1);
                    int time2 = entries.get(i + 2);

                    if (time2 - time <= 60) {
                        userData.put(name, "Name: " + name + ", Time: " + time + " " + time1 + " " + time2);
                        break;
                    }


                }
            }

        }

        return userData.values();


    }

    public static int convertToMinutes(String time) throws Exception {
        int hours = 0;
        int minutes = 0;
        if (time.length() == 4) {
            hours = Integer.parseInt(time.substring(0, 2));
            minutes = Integer.parseInt(time.substring(2));
        } else if (time.length() == 3) {
            hours = Integer.parseInt(time.substring(0, 2));
            minutes = Integer.parseInt(time.substring(1));
        } else if (time.length() == 2) {
            hours = Integer.parseInt(time.substring(0, 2));
        } else if(time.length()==1){
            hours = Integer.parseInt(time);
        } else{
            throw new Exception("Input not in proper format");
        }
        return hours * 60 + minutes;
    }
}
