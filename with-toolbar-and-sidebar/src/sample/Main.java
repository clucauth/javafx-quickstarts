package sample;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setTitle("With Toolbar and Sidebar");
        toScreenSize(primaryStage);
        primaryStage.show();
    }

    private Parent createContent() {
        BorderPane borderPane = new BorderPane();

        ToolBar toolbar = createToolbar();
        SplitPane splitPane = createSplitPane();

        borderPane.setTop(toolbar);
        borderPane.setCenter(splitPane);

        return borderPane;
    }

    private SplitPane createSplitPane() {
        TreeView sidebar = createSidebar();
        StackPane body = new StackPane();

        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(sidebar, body);
        splitPane.setDividerPositions(0.33);

        return splitPane;
    }

    private TreeView createSidebar() {
        TreeItem<String> treeRoot = new TreeItem<String>("Root node");
        treeRoot.getChildren().addAll(Arrays.asList(
                new TreeItem<String>("Child Node 1"),
                new TreeItem<String>("Child Node 2"),
                new TreeItem<String>("Child Node 3")));

        treeRoot.getChildren().get(2).getChildren().addAll(Arrays.asList(
                new TreeItem<String>("Child Node 4"),
                new TreeItem<String>("Child Node 5"),
                new TreeItem<String>("Child Node 6"),
                new TreeItem<String>("Child Node 7"),
                new TreeItem<String>("Child Node 8")));

        final TreeView treeView = new TreeView();
        treeView.setShowRoot(true);
        treeView.setRoot(treeRoot);
        treeRoot.setExpanded(true);

        return treeView;
    }

    private ToolBar createToolbar() {
        ToolBar toolbar = new ToolBar();
        toolbar.getItems().add(new Button("Home"));
        toolbar.getItems().add(new Button("Options"));
        toolbar.getItems().add(new Button("Help"));
        return toolbar;
    }

    private void toScreenSize(Stage stage) {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        //set Stage boundaries to visible bounds of the main screen
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
