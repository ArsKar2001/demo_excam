package com.example.demoexcam.javafx.controller.navigation;

import com.example.demoexcam.javafx.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.FileUrlResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class Navigation {
    private final Scene scene;
    private final ApplicationContext context;

    private final List<Controller> controllers = new ArrayList<>();

    public Navigation(Stage stage, ApplicationContext context) {
        this.context = context;
        scene = new Scene(new Pane());
        stage.setScene(scene);
    }

    public Controller load(String url) {
        try {
            FXMLLoader loader = new FXMLLoader(new FileUrlResource(url).getURL());
            loader.setControllerFactory(context::getBean);
            Node view = loader.load();
            Controller controller = loader.getController();
            controller.setView(view);
            return controller;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public void goBack() {
        if (controllers.size() > 1) {
            Controller controller = controllers.get(controllers.size() - 1);
            controllers.remove(controller);
            scene.setRoot((Parent) controller.getView());
        }
    }

    public void clearHistory() {
        while (controllers.size() > 1)
            controllers.remove(0);
        log.info("Deleted all scene");
    }

    public void show(Controller controller) {
        scene.setRoot((Parent) controller.getView());
        controllers.add(controller);
        log.info("Add new scene {}", controller.toString());
    }
}
