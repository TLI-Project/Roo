package com.TLI2.roo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class sensoInputController {

    @GetMapping("/UserData")
    public String userDataAPI() throws IOException, InterruptedException {
        return sensoController.getAPI(sensoController.mockInputs());
    }

    @PostMapping("/userInputs")
    public String userInputs(@RequestBody String[] userData) throws IOException, InterruptedException {
        System.out.println("Hello World!");
         return sensoController.getAPI(userData);
    }

//    @RestController // denotes to say it is a request handler and used to build REST API
//    public class MockSensoAPIController {
//        @GetMapping("/SensoUserData")
//        public String mockSensoAPI() throws IOException, InterruptedException {
//            return sensoController.getAPI(globalUserInputs);
//        }
//    }



}
