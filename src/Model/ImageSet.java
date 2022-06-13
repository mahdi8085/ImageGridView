package Model;

import java.util.ArrayList;

public class ImageSet {

    private ArrayList<ImageClass> list;

    public ImageSet(ArrayList<ImageClass> list) {
        this.list = new ArrayList<>();
        this.list.addAll(list);
    }

    public ArrayList<ImageClass> getList() {
        return list;
    }

    public void setList(ArrayList<ImageClass> list) {
        this.list = list;
    }
}
