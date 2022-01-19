public class InnerNested {
    public static void main(String[] args) {

        Car car = new Car();
        car.driver.go();
        Car.Passenger passenger = new Car.Passenger();

    }

}

class Car {
    private int wheelAngle = 0;
    private boolean ignition = false;
    public static boolean playerOn = false;
    public Driver driver = new Driver();

    public class Driver {

        public void go() {
            ignition = true;
            wheelAngle = 30;
            playerOn = true;
        }
    }

    public static class Passenger {

        public void go() {
            playerOn = true;
        }
    }

    public void move() {
        class Navigator {
            public void navigate(){
                ignition = true;
            }
        }
        Navigator navigator= new Navigator();

    }

    interface Remotable {
        void remote();
    }

    public void play(){
        new Remotable() {
            @Override
            public void remote() {

            }
        };
    }


}