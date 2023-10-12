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