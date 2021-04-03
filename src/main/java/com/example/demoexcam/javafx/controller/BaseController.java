package com.example.demoexcam.javafx.controller;

import com.example.demoexcam.javafx.StageInitialize;
import javafx.scene.Node;
import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class BaseController implements Controller {
    private Node view;

    @Override
    public Node getView() {
        return view;
    }

    @Override
    public void setView(Node view) {
        this.view = view;
    }

    @Override
    public void show() {
        preShow();
        StageInitialize.getNavigation().show(this);
        postShow();
    }

    abstract void preShow();

    abstract void postShow();
}
