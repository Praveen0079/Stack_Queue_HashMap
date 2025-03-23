package Queue_Stack;
import java.util.LinkedList;
import java.util.Queue;

class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {
    public static int findStartingPoint(PetrolPump[] pumps) {
        int totalSurplus = 0, currentSurplus = 0;
        int startIndex = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < pumps.length; i++) {
            int petrol = pumps[i].petrol;
            int distance = pumps[i].distance;

            totalSurplus += (petrol - distance);
            currentSurplus += (petrol - distance);
            queue.add(i);

            // If at any point currentSurplus is negative, reset queue
            if (currentSurplus < 0) {
                startIndex = i + 1;
                currentSurplus = 0;
                queue.clear();
            }
        }

        return (totalSurplus >= 0) ? startIndex : -1; // If totalSurplus is negative, no solution exists
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)
        };

        int start = findStartingPoint(pumps);
        if (start != -1) {
            System.out.println("Start at petrol pump: " + start);
        } else {
            System.out.println("No solution possible.");
        }
    }
}
