package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;


public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }
    public static StringBuilder readResults(){
        StringBuilder sb= new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/noamheller/" +
                "Documents/NOAM/WORK/Automation Course/Project1/src/main/java/converter/results.txt")))) {

            String line;
            while ((line = reader.readLine()) != null)
                sb.append(line + " \n");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    @Override
    public void start(Stage primaryStage) {

        StringBuilder stringBuilder = readResults();
        Text text1 = new Text(stringBuilder.toString());

        VBox root = new VBox();
        root.getChildren().addAll(text1);
        root.setSpacing(10);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: white;"+
                "-fx-background-color: #8fbc8f");

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Result File:");
        primaryStage.show();
    }
}

