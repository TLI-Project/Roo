package controllers;

import java.net.http.HttpRequest;

public class CreditScoreController {

    public int pingCreditScoreAPI(HttpRequest creditRequest){
        return generateCreditScore();
    }

    private static int generateCreditScore() {
        return (int) ((Math.random() * (800 - 600)) + 600);
    }


}
