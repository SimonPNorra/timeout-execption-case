package com.example.timeoutexecptioncase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerySlowController {

    @GetMapping("/timeout")
    public String timeout() {
        try {
            Thread.sleep(99999999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "timeout";
    }

}
