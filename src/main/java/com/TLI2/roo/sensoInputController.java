package com.TLI2.roo;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class sensoInputController {

    /**
     * Sample Get request from the frontend at Sensoeducation.link/UserData.
     */
    @GetMapping("/UserData")
    public String userDataAPI() throws IOException, InterruptedException {
        return sensoController.getAPI(sensoController.mockInputs());
    }

    /**
     * POST that takes a user info and returns the senso API response
     *
     * @param userData the financial information taken from the user.
     * @return the JSON given by the Senso API with the given userData.
     * @throws IOException TODO dont know why it would throw
     * @throws InterruptedException TODO dont know why it would throw
     */
    @PostMapping("/userInputs")
    public String userInputs(@RequestBody String userData) throws IOException, InterruptedException {
         return sensoController.getAPIInputs(userData);
    }
}
