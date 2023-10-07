package com.pratice.dsa.queues;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKthUserActivity {


    public static void main(String[] args) {

        List<UserEventsInfo> list = new ArrayList<>();
        list.add(new UserEventsInfo(1, 1689494802514l, "login"));
        list.add(new UserEventsInfo(2, 1689494802515l, "login"));
        list.add(new UserEventsInfo(3, 1689494802516l, "login"));
        list.add(new UserEventsInfo(1, 1689494802517l, "login"));
        list.add(new UserEventsInfo(5, 1689494802518l, "login"));
        list.add(new UserEventsInfo(3, 1689494802519l, "login"));
        list.add(new UserEventsInfo(2, 1689494802520l, "login"));
        list.add(new UserEventsInfo(4, 1689494802521l, "login"));
        list.add(new UserEventsInfo(3, 1689494802522l, "login"));

        System.out.println(new Gson().toJson(findKRecentEvents(list, 3)));


    }

    private static List<UserEventsInfo> findKRecentEvents(List<UserEventsInfo> list, int k) {

        PriorityQueue<UserEventsInfo> priorityQueue = new PriorityQueue<UserEventsInfo>(new Comparator<UserEventsInfo>() {
            @Override
            public int compare(UserEventsInfo o1, UserEventsInfo o2) {
                if (o1.time > o2.time) {
                    return -1;
                } else if (o1.time < o2.time) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        for (UserEventsInfo userEventsInfo : list) {
            priorityQueue.add(userEventsInfo);
        }

        List<UserEventsInfo> kElements = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            kElements.add(priorityQueue.poll());
        }


        return kElements;
    }


    static class UserEventsInfo {

        private Integer id;
        private long time;
        private String events;

        public UserEventsInfo(Integer id, long time, String events) {
            this.id = id;
            this.time = time;
            this.events = events;
        }


    }

}
/**
 * Problem Statement:
 * <p>
 * Given a running stream of users-activity data, you need to find out:
 * Recent K unique users who have done some activity
 * <p>
 * {userId1, 06:00, loggedIn}   last k=2 unique users answeers: (1)
 * {userId1, 13:00, loggedOut}  last k=2 unique users answeers: (1)
 * {userId1, 15:00, loggedIn}   last k=2 unique users answeers: (1)
 * {userId2, 15:00, loggedIn}   last k=2 unique users answeers: (1,2)
 * {userId3, 15:00, search}     last k=2 unique users answeers: (2,3)
 * {userId2, 15:01, search}
 * <p>
 * {userId2, 15:01, search}
 * {userId4, 15:01, like}
 * {userId4, 15:01, comment}
 * {userId6, 15:01, like}
 * {userId5, 15:01, like}
 * {userId7, 15:02, like}
 * {userId1, 15:02, comment}
 * {userId2, 15:02, like}
 * {userId4, 15:02, like}
 * {userId5, 15:02, comment}
 * {userId3, 15:02, like}
 * {userId1, 15:02, search}
 * {userId2, 15:01, like}
 * {userId4, 15:02, like}
 * {userId4, 15:02, comment}
 * {userId4, 15:02, like}
 * {userId4, 15:02, like}
 * {userId3, 15:02, comment}
 * {userId2, 15:02, like}
 * {userId3, 15:02, search}
 * <p>
 * first,you discuss the approach and then try to implement it."
 * <p>
 * u1-><ob1{time,activity},ob2{},..>
 * u2-><ob1, ob2,..>
 * u3-><ob1, ob2,..>
 * <p>
 * <p>
 * 15:03>last k=2unique users answeers:(3,2)
 * 15:01>last k=2unique users answeers:(6,5)
 * <p>
 * **********
 * <p>
 * List<Objects>
 * List()
 * Iterate over the list from recent to first.
 * if(!set.contains(key)){
 * set.add(key);
 * }
 * if(set.size==k){
 * return set;
 * }
 * ************************
 * <p>
 * Situation 1
 * <p>
 * Imagine you are responsible for monitoring a web application in production.
 * One day,you notice a sudden increase in response times.
 * How would you approach troubleshooting this performance issue?
 * What steps would you take to identify the root cause and resolve it?
 * <p>
 * <p>
 * Steps:one api
 * 1.I will check the api service layer.go through code.
 * 1.check if api completely has only business logic
 * Here i can see the traffic->
 * check the CPU Utilization+Memory utilization.
 * also will check if auto-scaling policy is working or not,if not will increase the containers
 * 2.has busniess plus db call inrternally
 * 3.has downstream calls
 * <p>
 * <p>
 * Situation 2:
 * Suppose you are working on a complex software project and encounter a persistent bug that seems to defy conventional debugging methods.
 * How would you approach debugging this issue?
 * What strategies or techniques would you employ to track down the problem and find a solution?
 * <p>
 * Situation 3:
 * You have been assigned to lead a software development project,
 * and you need to ensure that it follows a well-defined SDLC.
 * 1.How would you plan and execute the different stages of the SDLC,including requirements gathering,design,development,testing,and deployment?
 * 2.How would you handle any deviations or changes in project scope during the SDLC to ensure successful project delivery?
 */