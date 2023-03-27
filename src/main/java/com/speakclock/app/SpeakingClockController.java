package com.speakclock.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(produces = MediaType.TEXT_PLAIN_VALUE)
public class SpeakingClockController {

    @Autowired
    private SpeakingClock clock;

    @GetMapping("/clock/speak")
    public ResponseEntity<String> getTimeToWords() {
        return ResponseEntity.ok(clock.run());
    }
}
