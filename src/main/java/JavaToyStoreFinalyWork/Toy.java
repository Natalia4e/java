package JavaToyStoreFinalyWork;
import java.util.UUID;

// Напишите класс-конструктор у которого принимает минимум 3 строки,
//содержащие три поля id игрушки, текстовое название и частоту
//выпадения игрушки

public class Toy {
    public UUID id;
    public String name;
    public int weight;

    public Toy(UUID id, String nameToy, int weightToy) {
        this.id = id;
        this.name = nameToy;
        this.weight = weightToy;
    }

    public UUID getId() {
        return id;
    }

    public String getNameToy() {
        return name;
    }

    public void setNameToy(String nameToy) {
        this.name = nameToy;
    }

    public int getWeightToy() {
        return weight;
    }

    public void setWeightToy(int weightToy) {
        this.weight = weightToy;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", nameToy='" + name + '\'' +
                ", weightToy=" + weight +
                '}';
    }

    public void printInfo() {
        System.out.println(this);
    }
}