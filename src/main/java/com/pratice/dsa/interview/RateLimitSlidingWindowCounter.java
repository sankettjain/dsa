package com.pratice.dsa.interview;

import java.util.*;

public class RateLimitSlidingWindowCounter {

    static Integer MAX_REQUEST = 5;
    static Long MAX_EXPIRY_TIME = 2000l;
    static Integer NUMBER_OF_TIME_WINDOWS = 5;
    private final Map<Integer, Map<Long, Integer>> custReqCache;

    public RateLimitSlidingWindowCounter() {
        this.custReqCache = new HashMap<>();
    }

    boolean rateLimit(int customerId) {

        Long timeStamp = System.currentTimeMillis() / NUMBER_OF_TIME_WINDOWS;
        if (custReqCache.containsKey(customerId)) {
            Map<Long, Integer> timeStamps = custReqCache.get(customerId);
            List<Long> oldEntriesToBeDeleted = new ArrayList<>();
            int overallCount = 0;
            for (Long timeWindow : timeStamps.keySet()) {
                long diff = timeStamp - timeWindow;
                if (diff >= MAX_EXPIRY_TIME / NUMBER_OF_TIME_WINDOWS)
                    oldEntriesToBeDeleted.add(timeWindow);
                else
                    overallCount += timeStamps.get(timeWindow);
            }
            timeStamps.keySet().removeAll(oldEntriesToBeDeleted);
            if (overallCount >= MAX_REQUEST) {
                return false;
            } else {
                timeStamps.put(timeStamp, timeStamps.getOrDefault(timeStamp, 0) + 1);
                return true;
            }
        } else {
            Map<Long, Integer> timeStamps = new HashMap<>();
            timeStamps.put(timeStamp, 1);
            custReqCache.put(customerId, timeStamps);
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        RateLimitSlidingWindowCounter rateLimitProcessor = new RateLimitSlidingWindowCounter();
        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(2));
        System.out.println(rateLimitProcessor.rateLimit(3));
        System.out.println(rateLimitProcessor.rateLimit(4));
        System.out.println(rateLimitProcessor.rateLimit(5));
        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(1));

//        try {
//            Thread.sleep(3000l);
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(1));
        System.out.println(rateLimitProcessor.rateLimit(1));

    }
}
