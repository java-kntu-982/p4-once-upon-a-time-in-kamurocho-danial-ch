package ir.ac.kntu.graghic;

import ir.ac.kntu.gamePlay.Initializer;
import ir.ac.kntu.gamePlay.OrganizeSoldier;
import ir.ac.kntu.gamePlay.Player;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    public static Group root = new Group();
    public static Scene scene = new Scene(root, 1000, 600, false, SceneAntialiasing.BALANCED);
    public static Button missionButton = new Button("Missions");
    public static Button organizationButton = new Button("Organization");
    public static Button trainButton = new Button("Train");
    public static Button fortifyHQButton = new Button("Fortify HQ");
    public static Button unlockButton = new Button("Unlock New Hero");
    public static Button exitButton = new Button("Exit");
    public static Button mission1Button = new Button("Mission 1");
    public static Button mission2Button = new Button("Mission 2");
    public static Button backButton = new Button("Back");
    public static Button upgradeButton = new Button("Upgrade");
    public static ImageView menuBg = new ImageView(new Image("file:images/applicationImage.jpg"));
    public static ImageView inGameBg = new ImageView(new Image("file:images/gameBackgroundImage.jpg"));
    static final String musicFile = "sounds/backgound sound.mp3";
    public static javafx.scene.media.Media sound = new Media(new File(musicFile).toURI().toString());
    public static MediaPlayer mediaPlayer = new MediaPlayer(sound);

    public void start(Stage stage) {
        stage.setScene(scene);
        scene.setFill(Color.rgb(32,53,120,0.65));
        stage.setResizable(false);
        stage.setTitle("Once Upon a Time in Kamurocho!");

        //mediaPlayer.play();

        root.getChildren().add(menuBg);
        root.getChildren().add(inGameBg);
        inGameBg.setVisible(false);
        root.getChildren().add(missionButton);
        root.getChildren().add(organizationButton);
        root.getChildren().add(trainButton);
        root.getChildren().add(fortifyHQButton);
        root.getChildren().add(unlockButton);
        root.getChildren().add(exitButton);
        root.getChildren().add(mission1Button);
        root.getChildren().add(mission2Button);
        root.getChildren().add(backButton);
        root.getChildren().add(upgradeButton);
        backButton.setVisible(false);
        upgradeButton.setVisible(false);

        Initializer.Initialize();
        Design.designButtons();
        EventHandling.buttonEventHandling();
        OrganizeSoldier.organize();
        Player.moveFromStackToDefault();
        Design.rectangleDesign();
        Design.moneyDisplay();


        stage.show();
    }

    @Override
    public void stop() {
        mediaPlayer.stop();
    }
}