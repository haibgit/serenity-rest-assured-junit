package starter.petstore;

import java.util.ArrayList;

public class PetRefactor {
    public int id;
    public Category category;

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Object> getPhotoUrls() {
        return photoUrls;
    }

    public ArrayList<Object> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    public String name;
    public ArrayList<Object> photoUrls;
    public ArrayList<Object> tags;
    public String status;

    public class Category {
        public int id;
        public String name;
    }
}
