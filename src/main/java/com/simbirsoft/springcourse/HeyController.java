package com.simbirsoft.springcourse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeyController {

    @GetMapping("/hey")
    public ResponseEntity<String> sayHey(@PathVariable Long id) {
        return new ResponseEntity<>("Hey, tutorial", HttpStatus.OK);
    }

}
