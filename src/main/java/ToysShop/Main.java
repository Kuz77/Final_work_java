package ToysShop;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.addToy(new Toy(1, "Кукла", 5, 20));
        toyStore.addToy(new Toy(2, "Машинка", 10, 30));
        toyStore.addToy(new Toy(3, "хавигави", 8, 25));


        toyStore.updateDropPercentage(1, 10);
        toyStore.updateDropPercentage(2, 40);
        toyStore.updateDropPercentage(3, 50);


        Toy drawnToy = toyStore.drawToy();

        if (drawnToy != null) {
            System.out.println("Выиграна игрушка: " + drawnToy.getName());
            toyStore.addToWonToys(drawnToy);
        } else {
            System.out.println("Игрушки закончились");
        }


        toyStore.saveWonToysToFile();
    }
}
