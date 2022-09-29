package rikkei.academy.productservlet.model;

public class Product {
private int id;
private String proName;
private float proPrice;
private String description;
private String made;

    public Product() {
    }

    public Product(int id, String proName, float proPrice, String description, String made) {
        this.id = id;
        this.proName = proName;
        this.proPrice = proPrice;
        this.description = description;
        this.made = made;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public float getProPrice() {
        return proPrice;
    }

    public void setProPrice(float proPrice) {
        this.proPrice = proPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", proName='" + proName + '\'' +
                ", proPrice=" + proPrice +
                ", description='" + description + '\'' +
                ", made='" + made + '\'' +
                '}';
    }
}
