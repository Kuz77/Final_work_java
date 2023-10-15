package ToysShop;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.BufferedWriter;

public class ToyStore {
    private List<Toy> toys;
    private List<Toy> wonToys;

    public ToyStore() {
        toys = new ArrayList<>();
        wonToys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateDropPercentage(int toyId, int dropPercentage) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setDropPercentage(dropPercentage);
                break;
            }
        }
    }

    public Toy drawToy() {
        Random random = new Random();
        int totalDropPercentage = toys.stream().mapToInt(Toy::getDropPercentage).sum();
        int randomNumber = random.nextInt(totalDropPercentage);

        int accumulatedDropPercentage = 0;
        for (int i = 0; i < toys.size(); i++) {
            Toy toy = toys.get(i);
            accumulatedDropPercentage += toy.getDropPercentage();
            if (randomNumber < accumulatedDropPercentage) {
                toy.decreaseQuantity();
                toys.remove(i);
                return toy;
            }
        }

        return null;
    }

    public void addToWonToys(Toy toy) {
        wonToys.add(toy);
    }

    public void saveWonToysToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prizes.txt", true))) {
            for (Toy toy : wonToys) {
                writer.write("ID: " + toy.getId() + ", Название: " + toy.getName());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
