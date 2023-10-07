package com.pratice.dsa.queues;

import java.util.*;

public class EventsConnectDisconnect {
    public static void main(String[] argv) {
        String[][] events = {
                {"CONNECT", "Alice", "Bob"},
                {"DISCONNECT", "Bob", "Alice"},
                {"CONNECT", "Alice", "Charlie"},
                {"CONNECT", "Dennis", "Bob"},
                {"CONNECT", "Pam", "Dennis"},
                {"DISCONNECT", "Pam", "Dennis"},
                {"CONNECT", "Pam", "Dennis"},
                {"CONNECT", "Edward", "Bob"},
                {"CONNECT", "Dennis", "Charlie"},
                {"CONNECT", "Alice", "Nicole"},
                {"CONNECT", "Pam", "Edward"},
                {"DISCONNECT", "Dennis", "Charlie"},
                {"CONNECT", "Dennis", "Edward"},
                {"CONNECT", "Charlie", "Bob"}
        };

        System.out.println(calculateEvents(events, 1));

    }

    public static List<List<String>> calculateEvents(String[][] events, Integer N) {

        Map<String, Integer> userToActiveConnections = new HashMap<>();
        List<List<String>> ListOfList = new ArrayList<>();

        for (String[] eventsObject : events) {

            if ("CONNECT".equals(eventsObject[0])) {

                for (int i = 1; i < eventsObject.length; i++) {
                    if (userToActiveConnections.containsKey(eventsObject[i])) {
                        int val = userToActiveConnections.get(eventsObject[i]);
                        userToActiveConnections.put(eventsObject[i], val + 1);

                    } else {
                        userToActiveConnections.put(eventsObject[i], 1);
                    }

                }
            } else {
                for (int i = 1; i < eventsObject.length; i++) {
                    if (userToActiveConnections.containsKey(eventsObject[i])) {
                        int val = userToActiveConnections.get(eventsObject[i]);
                        userToActiveConnections.put(eventsObject[i], val - 1);

                    }
                }
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> connections = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<String, Integer> entry : userToActiveConnections.entrySet()) {
            connections.add(entry);
        }

        List<String> moreThanData = new ArrayList<>();
        List<String> lessThanData = new ArrayList<>();
        while (!connections.isEmpty()) {
            Map.Entry<String, Integer> value = connections.poll();
            if (value.getValue() >= N) {
                moreThanData.add(value.getKey());
            } else {
                lessThanData.add(value.getKey());
            }

        }
        ListOfList.add(lessThanData);
        ListOfList.add(moreThanData);
        return ListOfList;


    }
}