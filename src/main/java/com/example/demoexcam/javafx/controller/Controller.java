package com.example.demoexcam.javafx.controller;

import javafx.scene.Node;

public interface Controller {
    Node getView();
    void setView(Node view);

    void show();
}
