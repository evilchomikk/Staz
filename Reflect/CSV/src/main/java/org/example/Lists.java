package org.example;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Lists {
DateFormatImpl dateFormat = new DateFormatImpl();
    List<Dog> dogList = List.of(
            new Dog("Q",3,3456f,UUID.randomUUID(),dateFormat.dateFormat()),
            new Dog("W",4,3765f,UUID.randomUUID(),dateFormat.dateFormat()),
            new Dog("E",5,1459f,UUID.randomUUID(),dateFormat.dateFormat()));

    List<Car> carList = List.of(
            new Car("Ford",67871f,"blue",UUID.randomUUID(),dateFormat.dateFormat()),
            new Car("Ford",67871f,"blue",UUID.randomUUID(),dateFormat.dateFormat()),
            new Car("Ford",67871f,"blue",UUID.randomUUID(),dateFormat.dateFormat()));

    List<Dog> underdogList = List.of(
            new Underdog("Q",3,3456f,UUID.randomUUID(),dateFormat.dateFormat(),"underdog"),
            new Underdog("W",4,3765f,UUID.randomUUID(),dateFormat.dateFormat(),"underdog"),
            new Underdog("E",5,1459f,UUID.randomUUID(),dateFormat.dateFormat(),"underdog"));

    List<Dog> underunderdogList = List.of(
            new Underunderdog("Q",3,3456f,UUID.randomUUID(),dateFormat.dateFormat(),"underdog",3),
            new Underunderdog("W",4,3765f,UUID.randomUUID(),dateFormat.dateFormat(),"underdog",2),
            new Underunderdog("E",5,1459f,UUID.randomUUID(),dateFormat.dateFormat(),"underdog",4));
}
