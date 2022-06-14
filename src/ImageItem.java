import Model.ImageClass;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ImageItem {

    private ImageClass imageClass;
    private int i;
    private ImageGridView imageGridView;

    @FXML public ImageView img;
    @FXML public Label label;

    public void setData(ImageClass images, int i, ImageGridView imageGridView) {
        this.imageClass = images;
        this.i = i;
        this.imageGridView = imageGridView;
        Image image = new Image("http://gandom.co/devTest/1/images/" + images.getImages().get(i));
        img.setImage(image);
        label.setText(images.getDescription());
    }

    @FXML
    private void click(MouseEvent mouseEvent) {
        Image image = new Image("http://gandom.co/devTest/1/images/" + imageClass.getImages().get(i));
        imageGridView.largeImg.setImage(image);
    }
}
