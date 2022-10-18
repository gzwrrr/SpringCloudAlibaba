package com.gontoy.springcloud.controller;

import com.gontoy.springcloud.service.MessageProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author gzw
 */
@RestController
public class SendMessageController {
    @Resource
    private MessageProviderService messageProviderService;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return messageProviderService.send();
    }
}
