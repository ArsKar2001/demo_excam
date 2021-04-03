package com.example.demoexcam.javafx.controller;

import com.example.demoexcam.javafx.StageInitialize;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Log4j2
@Component
public class FirstController extends BaseController implements Initializable {
    public static final String RES_URL = "src/main/resources/ui/main.fxml";

    @Value("classpath:/ui/main.fxml")
    public static Resource resource;

    @FXML
    public Button btn1;

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn1.setOnAction(event -> {
            SecondController two = (SecondController) StageInitialize.getNavigation().load(SecondController.RES_URL);
            two.getLb().setText("Привет, Мир! :)");
            two.show();
        });
    }

    @Override
    void preShow() {

    }

    @Override
    void postShow() {

    }
}
