import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Lawn> lawns = new ArrayList<>();
        lawns.add(new Lawn(1, 0)); //
        lawns.add(new Lawn(2, 3)); // Вместо 0 подставляется количество
        lawns.add(new Lawn(3, 3)); // моркови на соответствующей полянке
        lawns.add(new Lawn(4, 3)); //
        lawns.add(new Lawn(5, 0)); //

        int maxTrips = 10;
        int maxWeightPerTrip = 5;

        int result = Main.algorithm(lawns, maxTrips, maxWeightPerTrip);

        System.out.println(result);
    }

    // Алгоритм
    static int algorithm (ArrayList<Lawn> lawns, int maxTrips, int maxWeightPerTrip)
    {
        int totalWeight = 0;

        for (int trip = 0; trip < maxTrips; trip++) {
            // Сортировка
            Collections.sort(lawns, (a, b) -> b.weight - a.weight);
            int currentWeight = 0;
            for (Lawn lawn : lawns) {
                while (lawn.remains > 0 && currentWeight + lawn.weight <= maxWeightPerTrip) {
                    currentWeight += lawn.weight;
                    lawn.remains--;
                }
            }
            totalWeight += currentWeight;
        }
        return totalWeight;
    }
    // Описание полянки
    static class Lawn {
        int weight;
        int remains;

        Lawn(int weight, int remaining) {
            this.weight = weight;
            this.remains = remaining;
        }
    }
}