# Урок 2. Знакомство с тестовыми фреймворками

## Задание 1.

Проект Vehicle. Написать тесты с использованием JUnit5:

В этом проекте, вы будете работать с проектом ""Vehicle"", который представляет собой иерархию классов, включающую абстрактный базовый класс ""Vehicle"" и два его подкласса ""Car"" и ""Motorcycle"".

Базовый класс ""Vehicle"" содержит абстрактные методы ""testDrive()"" и ""park()"", а также поля ""company"", ""model"", ""yearRelease"", ""numWheels"" и ""speed"".

Класс ""Car"" расширяет ""Vehicle"" и реализует его абстрактные методы. При создании объекта ""Car"", число колес устанавливается в 4, а скорость в 0. В методе ""testDrive()"" скорость устанавливается на 60, а в методе ""park()"" - обратно в 0.

Класс ""Motorcycle"" также расширяет ""Vehicle"" и реализует его абстрактные методы. При создании объекта ""Motorcycle"", число колес устанавливается в 2, а скорость в 0. В методе ""testDrive()"" скорость устанавливается на 75, а в методе ""park()"" - обратно в 0.

### Исходные классы

См. исходные классы в папке [](../../../main/java/seminar02/)

## Решение

См. файл с тестами в [VehicleTest.java](./VehicleTest.java)

Либо см. ниже код файла **VehicleTest.java** с тестами.

```java

package seminar02Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminar02.Car;
import seminar02.Motorcycle;
import seminar02.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
private Car car;
private Motorcycle motorcycle;
private Vehicle vehicle;

    @BeforeEach
    public void setUp(){
        car = new Car("BMV", "X5", 2021);
        motorcycle = new Motorcycle("Honda", "Go", 2019);
    }

    /**
     * Проверить, что экземпляр объекта Car также является экземпляром транспортного средства (используя оператор instanceof).
     */
    @Test
    public void testInstanceOf(){
        assertInstanceOf(Vehicle.class, car,"Car's object must has type of Vehicle");
    }

    /**
     * Проверить, что объект Car создается с 4-мя колесами.
     */
    @Test
    public void testCarsWheels(){
        assertEquals(4, car.getNumWheels(), "Car must has 4 wheels!");
    }

    /**
     * Проверить, что объект Motorcycle создается с 2-мя колесами.
     */
    @Test
    public void testMotorbikeWheels(){
        assertEquals(2,motorcycle.getNumWheels(),"Motorbike must has 2 wheels!");
    }

    /**
     * Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).
     */
    @Test
    public void testCarsSpeed(){
        car.testDrive();
        assertEquals(60, car.getSpeed(), "Speed of the car must be 60 km per hour in testdrive case.");
    }


    /**
     * Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения (используя метод testDrive()).
     */
    @Test
    public void testMotorbikesSpeed(){
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed(), "Speed of the car must be 75 km per hour in test drive case.");
    }


    /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) машина останавливается (speed = 0).
     */
    @Test
    public void testParkingCar(){
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed(), "Speed of car must be zero because car has stoped.");
    }

    /**
     * Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта) мотоцикл останавливается (speed = 0).
     */
    @Test
    public void testParkingMotorbike(){
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed(), "Speed of motorbike must be zero because it has stoped.");
    }

}
```