package Model;

import java.util.ArrayList;

public class ImageClass {

    private String description;
    private ArrayList<String> images;

    public ImageClass(String description, ArrayList<String> list) {
        this.description = description;
        this.images = new ArrayList<>();
        this.images.addAll(list);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }
}
