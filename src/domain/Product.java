package domain;

import java.util.Date;

public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private String image;
    private Date publish_time;
    private int view_count;
    private String user_id; // 发布者ID

    // Getter 和 Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Date getPublish_time() { return publish_time; }
    public void setPublish_time(Date publish_time) { this.publish_time = publish_time; }

    public int getView_count() { return view_count; }
    public void setView_count(int view_count) { this.view_count = view_count; }

    public String getUser_id() { return user_id; }
    public void setUser_id(String user_id) { this.user_id = user_id; }
}
