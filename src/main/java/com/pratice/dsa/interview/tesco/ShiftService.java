package com.pratice.dsa.interview.tesco;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiftService {


    public static Map<String, List<ShiftTimings>> userIdtoShifts = new HashMap<>();

    @PostConstruct
    public static void init() {

        userIdtoShifts.put("1", Arrays.asList(new ShiftTimings(8, 10, ""), new ShiftTimings(10, 12, ""), new ShiftTimings(14, 19, "")));

    }


    public static List<ShiftTimings> getShiftTimings(String userId) {

        List<ShiftTimings> mergedRanges = new ArrayList<>();
        if (userIdtoShifts.containsKey(userId)) {

            List<ShiftTimings> shifts = userIdtoShifts.get(userId);
            mergedRanges = mergeRanges(shifts);

        }

        return mergedRanges;
    }

    public static List<ShiftTimings> mergeRanges(List<ShiftTimings> meetings) {

        // make a copy so we don't destroy the input
        List<ShiftTimings> sortedMeetings = new ArrayList<>();
        for (ShiftTimings meeting : meetings) {
            ShiftTimings meetingCopy = new ShiftTimings(meeting.getStartTime(), meeting.getEndTime());
            sortedMeetings.add(meetingCopy);
        }

//        // sort by start time
//        Collections.sort(sortedMeetings, new Comparator<ShiftTimings>() {
//            @Override
//            public int compare(ShiftTimings m1, ShiftTimings m2) {
//                return m1.getStartTime() - m2.getStartTime();
//            }
//        });

        Collections.sort(sortedMeetings, (o1, o2) -> o1.getStartTime() - o2.getStartTime());

        // initialize mergedMeetings with the earliest meeting
        List<ShiftTimings> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(sortedMeetings.get(0));

        for (ShiftTimings currentMeeting : sortedMeetings) {

            ShiftTimings lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

            // if the current meeting overlaps with the last merged meeting, use the
            // later end time of the two
            if (currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
                lastMergedMeeting.setEndTime(Math.max(lastMergedMeeting.getEndTime(), currentMeeting.getEndTime()));

                // add the current meeting since it doesn't overlap
            } else {
                mergedMeetings.add(currentMeeting);
            }
        }

        return mergedMeetings;
    }

    public static void main(String[] args) {
        init();
        System.out.println(getShiftTimings("1"));
    }


}
