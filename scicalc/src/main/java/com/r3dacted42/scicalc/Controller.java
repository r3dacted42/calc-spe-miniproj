package com.r3dacted42.scicalc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class Controller {

    @GetMapping("/add")
    @ResponseBody
    public ResponseEntity<Double> add(@RequestParam Double a, @RequestParam Double b) {
        if (a == null || b == null || Double.isNaN(a) || Double.isNaN(b)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(a + b, HttpStatus.OK);
    }

    @GetMapping("/mul")
    @ResponseBody
    public ResponseEntity<Double> multiply(@RequestParam Double a, @RequestParam Double b) {
        if (a == null || b == null || Double.isNaN(a) || Double.isNaN(b)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(a * b, HttpStatus.OK);
    }

    @GetMapping("/sub")
    @ResponseBody
    public ResponseEntity<Double> subtract(@RequestParam Double a, @RequestParam Double b) {
        if (a == null || b == null || Double.isNaN(a) || Double.isNaN(b)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(a - b, HttpStatus.OK);
    }

    @GetMapping("/div")
    @ResponseBody
    public ResponseEntity<Double> divide(@RequestParam Double a, @RequestParam Double b) {
        if (a == null || b == null || Double.isNaN(a) || Double.isNaN(b) || b.compareTo(0.0) == 0 || b == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(a / b, HttpStatus.OK);
    }

    @GetMapping("/sqrt")
    @ResponseBody
    public ResponseEntity<Double> sqrt(@RequestParam Double a) {
        if (a == null || Double.isNaN(a) || a < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(Math.sqrt(a), HttpStatus.OK);
    }
    
    @GetMapping("/fact")
    @ResponseBody
    public ResponseEntity<Long> factorial(@RequestParam Long a) {
        if (a == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        long res = 1;
        for (long i = a; i > 1; i--) res *= i;
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/ln")
    @ResponseBody
    public ResponseEntity<Double> ln(@RequestParam Double a) {
        if (a == null || Double.isNaN(a) || a < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(Math.log(a), HttpStatus.OK);
    }

    @GetMapping("/pow")
    @ResponseBody
    public ResponseEntity<Double> pow(@RequestParam Double a, @RequestParam Double b) {
        if (a == null || b == null || Double.isNaN(a) || Double.isNaN(b)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(Math.pow(a, b), HttpStatus.OK);
    }
}