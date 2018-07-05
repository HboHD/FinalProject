package com.journal.finalProject;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
    private final WeatherRepository repo;
    final Grid<WeatherReport> grid;

    public MainView(WeatherRepository repo) {
        this.repo = repo;
        this.grid = new Grid<>(WeatherReport.class);
        add(grid);
        add(new Button("Click me", e -> Notification.show("Hello Spring+Vaadin user!")));
        listCustomers();
    }

    private void listCustomers() {
        grid.setItems(repo.findAll());
    }
}