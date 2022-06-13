import Model.ImageClass;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageItem {

    @FXML private ImageView img;
    @FXML private Label label;

    public void setData(ImageClass images, int i) {
        Image image = new Image("http://gandom.co/devTest/1/images/" + images.getImages().get(i));
        img.setImage(image);
        label.setText(images.getDescription());
    }
}
