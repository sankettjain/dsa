package com.pratice.dsa.interview.tesco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftTimings {

    private Integer startTime;
    private Integer endTime;
    private String name;

    public ShiftTimings(Integer startTime, Integer endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
