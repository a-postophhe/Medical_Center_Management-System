import java.io.Serializable;
import java.util.Objects;

public class Order implements Serializable {
    private static final long serialVersionUID=5058424088721704969L;
    private final Medicine medicine;
    private final Student student;
    private final boolean payLater;
    public Order(Medicine medicine, Student student, boolean payLater) {
        this.medicine = medicine;
        this.student = student;
        this.payLater = payLater;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return payLater == order.payLater && Objects.equals(medicine, order.medicine) && Objects.equals(student, order.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicine, student, payLater);
    }

    @Override
    public String toString() {
        return "Order{" +
                "medicine=" + medicine +
                ", student=" + student +
                ", payLater=" + payLater +
                '}';
    }
}
