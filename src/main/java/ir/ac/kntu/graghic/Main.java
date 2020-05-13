package ir.ac.kntu.graghic;

import ir.ac.kntu.gamePlay.Initializer;
import ir.ac.kntu.gamePlay.OrganizeSoldier;
import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import javax.sound.sampled.AudioInputStream;
import java.beans.EventHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    public static Group root = new Group();
    public static Scene scene = new Scene(root, 1000, 600, false, SceneAntialiasing.BALANCED);
    public static Button missionButton = new Button("Missions");
    public static Button organizationButton = new Button("Organization");
    public static Button trainButton = new Button("Train");
    public static Button fortifyHQButton = new Button("Fortify HQ");
    public static Button exitButton = new Button("Exit");
    public static Button mission1Button = new Button("Mission 1");
    public static Button mission2Button = new Button("Mission 2");
    public static Image background = new Image("file:C:/Users/Asus/Desktop/projects/Java/p4-once-upon-a-time-in-kamurocho-danial-ch/images/applicationImage.jpg");
    public static ImageView imageView = new ImageView(background);
    static final String musicFile = "C:/Users/Asus/Desktop/projects/Java/p4-once-upon-a-time-in-kamurocho-danial-ch/sounds/backgound sound.mp3";
    public static javafx.scene.media.Media sound = new Media(new File(musicFile).toURI().toString());
    public static MediaPlayer mediaPlayer = new MediaPlayer(sound);

    public void start(Stage stage) {
        stage.setScene(scene);
        scene.setFill(Color.rgb(32,53,120,0.65));
        stage.setResizable(false);
        stage.setTitle("Once Upon a Time in Kamurocho!");

        mediaPlayer.play();

        Initializer.Initialize();
        Design.designButtons();
        EventHandling.buttonEventHandling();
        OrganizeSoldier.organize();
        Design.rectangleDesign();

        root.getChildren().addAll(imageView);
        root.getChildren().add(missionButton);
        root.getChildren().add(organizationButton);
        root.getChildren().add(trainButton);
        root.getChildren().add(fortifyHQButton);
        root.getChildren().add(exitButton);
        root.getChildren().add(mission1Button);
        root.getChildren().add(mission2Button);


        stage.show();
    }

    @Override
    public void stop() {
        mediaPlayer.stop();
    }
}