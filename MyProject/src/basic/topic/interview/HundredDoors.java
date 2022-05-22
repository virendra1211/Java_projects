package basic.topic.interview;
/*
 * : What state are the doors in after the last pass? Which are open, which are closed?
 */
public class HundredDoors {
    public static void main(String[] args) {
        boolean[] doors = new boolean[101];
        for (int i = 1; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                if (j % i == 0) {
                    doors[j] = !doors[j];
                }
            }
        }
        for (int i = 1; i <= 100; i++) {
            System.out.print("Door " + i + " is ");
            if (doors[i] == true) {
                System.out.println("opened");
            } else {
                System.out.println("closed");
            }
        }
    }
}