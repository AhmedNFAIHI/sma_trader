package gui;

import agents.ConsommateurAgent;
import agents.TraderAgent;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConsommateurGui extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ConsommateurAgent consommateurAgent = new ConsommateurAgent();
        VBox pane = new VBox();
        TextField companyName = new TextField();
        TextField receiver = new TextField();
        Button send = new Button("SEND");
        ObservableList<String> list = FXCollections.observableArrayList();
        ListView<String> companies = new ListView<>(list);

        send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                consommateurAgent.sendMsg(companyName.getText());
                System.out.println(companyName.getText());
                list.add("Company : " + companyName.getText() + ", Price : " + consommateurAgent.getReceivedMessage());
            }
        });

        pane.setPadding(new Insets(20));
        pane.getChildren().addAll(companyName, receiver, send, companies);

        primaryStage.setTitle("Consommateur");
        Scene scene = new Scene(pane, 300, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
