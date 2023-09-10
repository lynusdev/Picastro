import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class BildbearbeitungGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/gui.fxml"));
            VBox root = (VBox) loader.load();
            Scene scene = new Scene(root);
            
            Image image = new Image("/view/rgb.png");
            primaryStage.getIcons().add(image);
            primaryStage.setTitle("Picastro");
            
            primaryStage.setScene(scene);
            primaryStage.show();
        } 
        catch(Exception e)    {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}