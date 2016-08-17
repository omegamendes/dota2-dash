package com.omegamendes.dash.endpoints;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mame on 16/08/2016.
 */
@RestController
public class Dota2DashEndpoint {

        @RequestMapping("/")
        @ResponseBody
        String home(@RequestBody(required = false) List<String> names) {
            return "home";
        }
}
