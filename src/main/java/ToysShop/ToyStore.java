package ToysShop;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int toyId, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setDropPercentage(weight);
                break;
            }
        }
    }

    public Toy drawToy() {
        Random random = new Random();
        int totalWeight = toys.stream().mapToInt(Toy::getDropPercentage).sum();
        int randomNumber = random.nextInt(totalWeight);

        int accumulatedWeight = 0;
        for (int i = 0; i < toys.size(); i++) {
            Toy toy = toys.get(i);
            accumulatedWeight += toy.getDropPercentage();
            if (randomNumber < accumulatedWeight) {
                toy.decreaseQuantity();
                toys.remove(i);
                return toy;
            }
        }

        return null;
    }


}
