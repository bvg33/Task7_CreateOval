package com.epam.task7.logic.parser;

import com.epam.task7.model.Oval;
import com.epam.task7.model.Point;

public class OvalParser  implements Parser<Oval>{

    @Override
    public Oval parse(String line) {
        String[]coordinates=line.split(" ");
        double xOne=Double.parseDouble(coordinates[0]);
        double yOne=Double.parseDouble(coordinates[1]);
        double xTwo=Double.parseDouble(coordinates[2]);
        double yTwo=Double.parseDouble(coordinates[3]);
        Point pointOne=new Point(xOne,yOne);
        Point pointTwo=new Point(xTwo,yTwo);
        Oval oval=new Oval(pointOne,pointTwo);
        return oval;
    }
}
