import Model.ImageSet;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class ImageGridView implements Initializable {

    @FXML public ImageView largeImg;
    @FXML public GridPane gridPane;

    private static HttpURLConnection connection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ImageSet list = receiveInput();

        assert list != null;

        int column = 0;
        int row = 1;

        for (int i = 0; i < list.getList().size(); i++) {

            for (int j = 0; j < list.getList().get(i).getImages().size(); j++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ImageItem.fxml"));

                try {
                    VBox imageClass = fxmlLoader.load();
                    ImageItem imageItem = fxmlLoader.getController();
                    imageItem.setData(list.getList().get(i), j, this);

                    if (column == 2) {
                        column = 0;
                        row++;
                    }

                    gridPane.add(imageClass, column++, row);
                    GridPane.setMargin(imageClass, new Insets(10));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private ImageSet receiveInput() {

        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();

        try {
            URL url = new URL("http://gandom.co/devTest/1/home");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status > 299) {

                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null)
                    responseContent.append(line);
                reader.close();

            } else {

                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null)
                    responseContent.append(line);
                reader.close();
            }

            Gson gson = new Gson();
            ImageSet list = gson.fromJson(responseContent.toString(), ImageSet.class);

            return list;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return null;
    }
}
