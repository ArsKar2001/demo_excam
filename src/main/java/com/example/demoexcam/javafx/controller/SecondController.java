package com.example.demoexcam.javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.demoexcam.javafx.StageInitialize.getNavigation;

@Log4j2
@Setter
@Getter
@Component
public class SecondController extends BaseController implements Initializable {
    public static final String RES_URL = "src/main/resources/ui/two.fxml";

    @FXML
    private Button btn2;
    @FXML
    private Label lb;

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
        btn2.setOnAction(event -> getNavigation().load(FirstController.RES_URL).show());
    }

    @Override
    void preShow() {

    }

    @Override
    void postShow() {

    }
}
