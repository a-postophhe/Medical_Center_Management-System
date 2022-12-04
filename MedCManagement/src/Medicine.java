import java.io.Serializable;
import java.util.Objects;

public class Medicine implements Serializable {
    private final int itemId;
    private final String name;
    private final int price;
    private int defaultQuant;
    public Medicine(int itemId,String name, int price,int defaultQuant){
        this.itemId=itemId;
        this.name=name;
        this.price=price;
        this.defaultQuant=defaultQuant;
    }

    public int getDefaultQuant() {
        return defaultQuant;
      }

    public void setDefaultQuant(int defaultQuant){
        this.defaultQuant=defaultQuant;
    }
    public void reduceQuant(){this.defaultQuant--;}
    public int getItemId() {
        return itemId;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return getItemId() == medicine.getItemId() && getPrice() == medicine.getPrice() && Objects.equals(getName(), medicine.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getName(), getPrice());
    }
}
