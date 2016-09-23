package com.omegamendes.dash.endpoints;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mame on 16/08/2016.
 */
@RestController
public class Dota2DashEndpoint {

        @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
        @ResponseBody
        ResponseEntity<List<String>> home(@RequestBody(required = false) ArrayList<String> names) {

            names.add("backend");
            ResponseEntity<List<String>> entity = new ResponseEntity<>(names, HttpStatus.OK);

            return entity;
        }

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<String>> get() {

        ResponseEntity<List<String>> entity = new ResponseEntity<>(HttpStatus.OK);

        return entity;
    }
}
