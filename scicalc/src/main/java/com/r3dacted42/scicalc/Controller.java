package com.r3dacted42.scicalc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.r3dacted42.scicalc.dto.DoubleResponse;
import com.r3dacted42.scicalc.dto.LongResponse;

@RestController
@RequestMapping("/api")
class Controller {

    @GetMapping("/add")
    @ResponseBody
    public ResponseEntity<DoubleResponse> add(@RequestParam Double a, @RequestParam Double b) {
        if (a == null || b == null || Double.isNaN(a) || Double.isNaN(b)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new DoubleResponse(a + b), HttpStatus.OK);
    }

    @GetMapping("/mul")
    @ResponseBody
    public ResponseEntity<DoubleResponse> multiply(@RequestParam Double a, @RequestParam Double b) {
        if (a == null || b == null || Double.isNaN(a) || Double.isNaN(b)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new DoubleResponse(a * b), HttpStatus.OK);
    }

    @GetMapping("/sub")
    @ResponseBody
    public ResponseEntity<DoubleResponse> subtract(@RequestParam Double a, @RequestParam Double b) {
        if (a == null || b == null || Double.isNaN(a) || Double.isNaN(b)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new DoubleResponse(a - b), HttpStatus.OK);
    }

    @GetMapping("/div")
    @ResponseBody
    public ResponseEntity<DoubleResponse> divide(@RequestParam Double a, @RequestParam Double b) {
        if (a == null || b == null || Double.isNaN(a) || Double.isNaN(b) || b.compareTo(0.0) == 0 || b == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new DoubleResponse(a / b), HttpStatus.OK);
    }

    @GetMapping("/sqrt")
    @ResponseBody
    public ResponseEntity<DoubleResponse> sqrt(@RequestParam Double a) {
        if (a == null || Double.isNaN(a) || a < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new DoubleResponse(Math.sqrt(a)), HttpStatus.OK);
    }
    
    @GetMapping("/fact")
    @ResponseBody
    public ResponseEntity<LongResponse> factorial(@RequestParam Long a) {
        if (a == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        long res = 1;
        for (long i = a; i > 1; i--) res *= i;
        return new ResponseEntity<>(new LongResponse(res), HttpStatus.OK);
    }

    @GetMapping("/ln")
    @ResponseBody
    public ResponseEntity<DoubleResponse> ln(@RequestParam Double a) {
        if (a == null || Double.isNaN(a) || a < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new DoubleResponse(Math.log(a)), HttpStatus.OK);
    }

    @GetMapping("/pow")
    @ResponseBody
    public ResponseEntity<DoubleResponse> pow(@RequestParam Double a, @RequestParam Double b) {
        if (a == null || b == null || Double.isNaN(a) || Double.isNaN(b)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new DoubleResponse(Math.pow(a, b)), HttpStatus.OK);
    }
}