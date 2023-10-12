package ToysShop;

public class Toy {
    private int id;
    private String name;
    private int quantity;
    private int dropPercentage;

    public Toy(int id, String name, int quantity, int dropPercentage) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.dropPercentage = dropPercentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDropPercentage() {
        return dropPercentage;
    }

    public void setDropPercentage(int dropPercentage) {
        this.dropPercentage = dropPercentage;
    }
    public void decreaseQuantity() {
        quantity--;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", dropPercentage=" + dropPercentage +
                '}';
    }
}
