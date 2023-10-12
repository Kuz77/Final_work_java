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
        toyStore.addToy(new Toy(1, "машинка", 1, 33));
        toyStore.addToy(new Toy(2, "кукла", 1, 33));
        toyStore.addToy(new Toy(3, "айфон", 1, 33));


        Toy drawnToy = toyStore.drawToy();

        if (drawnToy != null) {
            System.out.println("Выиграна игрушка: " + drawnToy.getName());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("prizes.txt", true))) {
                writer.write("ID: " + drawnToy.getId() + ", Название: " + drawnToy.getName());
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Игрушки закончились");
        }
    }


}
