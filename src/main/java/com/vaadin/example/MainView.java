package com.vaadin.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a grid of Customers.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MainView extends VerticalLayout {

    private CustomerService service = CustomerService.getInstance();
    private Grid<Customer> grid = new Grid<>(Customer.class);

    public MainView() {
        grid.setColumns("firstName", "lastName", "status" );
        add(grid);
        setSizeFull();

        updateList();
    }

    public void updateList() {
        grid.setItems(service.findAll());
    }
}
