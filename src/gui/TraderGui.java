package gui;

import agents.TraderAgent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TraderGui extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TraderAgent traderAgent = new TraderAgent();
        ObservableList<String> list = FXCollections.observableArrayList();

        VBox pane = new VBox();
        ListView<String> companies = new ListView<>(list);

        pane.getChildren().add(companies);

        primaryStage.setTitle("Consommateur");
        Scene scene = new Scene(pane, 300, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
