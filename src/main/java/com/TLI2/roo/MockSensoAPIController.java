package com.TLI2.roo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MockSensoAPIController {
    @GetMapping("/mockSensoAPI")
    public String mockSensoAPI() throws IOException, InterruptedException {
        return sensoController.getAPI(sensoController.mockInputs());
    }
}
