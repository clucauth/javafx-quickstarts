package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setTitle("With Menu");
        toScreenSize(primaryStage);
        primaryStage.show();
    }

    private void toScreenSize(Stage stage) {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        //set Stage boundaries to visible bounds of the main screen
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());
    }

    private Parent createContent() {
        VBox container = new VBox(20);

        final MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        MenuItem fileNew = createFileNew();
        MenuItem fileOpen = createFileOpen();
        MenuItem fileSave = createFileSave();
        MenuItem fileExit = createFileExit();
        fileMenu.getItems().addAll(fileNew, fileOpen, fileSave, new SeparatorMenuItem(), fileExit);

        Menu helpMenu = new Menu("Help");
        MenuItem helpHelp = createHelpHelp();
        MenuItem helpAbout = createHelpAbout();
        helpMenu.getItems().addAll(helpHelp, helpAbout);

        menuBar.getMenus().addAll(fileMenu, helpMenu);

        container.getChildren().addAll(menuBar);
        return container;
    }

    private MenuItem createFileNew() {
        MenuItem menuItem = new MenuItem("New");
        menuItem.setDisable(true);
        return menuItem;
    }

    private MenuItem createFileOpen() {
        MenuItem menuItem = new MenuItem("Open");
        menuItem.setDisable(true);
        return menuItem;
    }

    private MenuItem createFileSave() {
        MenuItem menuItem = new MenuItem("Save");
        menuItem.setDisable(true);
        return menuItem;
    }

    private MenuItem createFileExit() {
        MenuItem menuItem = new MenuItem("Exit");
        menuItem.setOnAction((ActionEvent t) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Are you sure you want to exit the program?");
            alert.showAndWait()
                    .filter(response -> response == ButtonType.OK)
                    .ifPresent(response -> Platform.exit());
        });
        return menuItem;
    }

    private MenuItem createHelpHelp() {
        MenuItem menuItem = new MenuItem("Help");
        menuItem.setDisable(true);
        return menuItem;
    }

    private MenuItem createHelpAbout() {
        MenuItem menuItem = new MenuItem("About");
        menuItem.setDisable(true);
        return menuItem;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
