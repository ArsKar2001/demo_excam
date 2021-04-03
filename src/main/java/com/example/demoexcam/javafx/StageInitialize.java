package com.example.demoexcam.javafx;

import com.example.demoexcam.javafx.controller.FirstController;
import com.example.demoexcam.javafx.controller.navigation.Navigation;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import static com.example.demoexcam.javafx.JavaFXApplication.StageReadyEvent;

@Log4j2
@Component
public class StageInitialize implements ApplicationListener<StageReadyEvent> {
    private final String title;
    private final ApplicationContext applicationContext;
    private static Navigation navigation;

    public StageInitialize(@Value("${spring.application.name}") String title, ApplicationContext applicationContext) {
        this.title = title;
        this.applicationContext = applicationContext;
    }

    public static Navigation getNavigation() {
        return navigation;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.getStage();
        navigation = new Navigation(stage, applicationContext);
        stage.setTitle(title);
        stage.show();

        StageInitialize.getNavigation().load(FirstController.RES_URL).show();
    }
}
