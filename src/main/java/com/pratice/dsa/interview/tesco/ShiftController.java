package com.pratice.dsa.interview.tesco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ShiftController {

    @Autowired


    @GetMapping("/getShiftTimings/{userId}")
    public String getShiftTimings(@PathVariable String userId) {

        return null;
    }

}
