package com.TLI2.roo;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class sensoInputController {

    @GetMapping("/UserData")
    public String userDataAPI() throws IOException, InterruptedException {
        return sensoController.getAPI(sensoController.mockInputs());
    }

    @PostMapping("/userInputs")
//    @ResponseBody
    public String userInputs(@RequestBody String userData) throws IOException, InterruptedException {
         return sensoController.getAPIInputs(userData);
    }
}
