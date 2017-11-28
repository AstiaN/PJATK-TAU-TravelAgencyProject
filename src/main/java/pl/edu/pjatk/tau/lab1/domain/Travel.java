package pl.edu.pjatk.tau.lab1.domain;

public class Travel {

    private int id;
    private String from;
    private String direction;
    private int price;

    public Travel(int id, String from, String direction, int price) {
        this.id = id;
        this.from = from;
        this.direction = direction;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}