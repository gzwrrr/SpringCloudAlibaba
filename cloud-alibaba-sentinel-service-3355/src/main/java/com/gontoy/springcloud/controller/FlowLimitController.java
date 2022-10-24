package com.gontoy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gzw
 */
@Slf4j
@RestController
@RequestMapping("/sentinel")
public class FlowLimitController {
    @GetMapping("/flowLimit")
    public String flowLimit() {
        return "FlowLimitController | Flow Limit";
    }
}
