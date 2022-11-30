package client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.File;
import java.util.List;

public class HighScoreController {
    @FXML
    private ImageView image1HS, image2HS, image3HS, image4HS, image5HS, image6HS, image7HS, image8HS, image9HS, image10HS;

    @FXML
    private Label label1HS, label2HS, label3HS, label4HS, label5HS, label6HS, label7HS, label8HS, label9HS, label10HS;
    private Stage stage;

    protected void setHighScore(List<String[]> highScoreList, Stage stage) {
        this.stage = stage;
        ImageView[] highScoreAvatars = new ImageView[] {image1HS, image2HS, image3HS, image4HS,
                image5HS, image6HS, image7HS, image8HS, image9HS, image10HS};
        Label[] highScoreInfo = new Label[] {label1HS, label2HS, label3HS, label4HS,
                label5HS, label6HS, label7HS, label8HS, label9HS, label10HS};

        Platform.runLater(() -> {
            for (int i = 0; i < highScoreList.size() && i < 10; i++) {
                String[] currentScore = highScoreList.get(i);
                File file = new File("src/main/resources/client/avatars/avatar-" +
                        Integer.parseInt(currentScore[0]) + ".png");
                Image image = new Image(file.toURI().toString());
                highScoreAvatars[i].setImage(image);
                StringBuilder currentScoreInfo = new StringBuilder();
                for (int j = 1; j < currentScore.length; j++) {
                    currentScoreInfo.append(currentScore[j]).append(" ");
                }
                highScoreInfo[i].setText(currentScoreInfo.toString());
            }
        });
    }

    public void onHighScoreBackButtonClick() {
        stage = (Stage) image1HS.getScene().getWindow();
        stage.close();
    }









}
