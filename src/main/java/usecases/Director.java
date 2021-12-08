package usecases;


import entities.Car;

import java.sql.ResultSet;

public class Director {

    private CarBuilder carBuilder;

    public void setBuilder(CarBuilder b){
        this.carBuilder = b;
    }

    public constructAClass(CarBuilder b, ResultSet carSet){
        b.buildEngine(carSet.);
        b.buildInterior();
        b.buildPerformancePackage();
    }


}
