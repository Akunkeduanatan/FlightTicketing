package com.smk.view;
import com.smk.MainView;
import com.smk.dao.BookingDao;
import com.smk.dao.LocationDao;
import com.smk.dao.ScheduleDao;
import com.smk.model.Booking;
import com.smk.model.Location;
import com.smk.model.Schedule;
import com.smk.model.dto.ScheduleDTO;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;

import static com.smk.view.CreateBooking.createBookingRenderer;

@PageTitle("Create Booking")
@Route(value = "create-booking", layout = MainView.class)
public class SearchBooking extends VerticalLayout {

    private LocationDao locationDao;
    private final BookingDao bookingDao = new BookingDao();
    private final ScheduleDao scheduleDao;

    public SearchBooking() {
        locationDao = new LocationDao();
        scheduleDao = new ScheduleDao();
        createForm();
    }

    private void createForm() {
        setAlignItems(Alignment.STRETCH);
        // UI enhancements such as spacing, padding, and horizontal form layout
        setSpacing(true);
        setPadding(true);
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setWidthFull();
        formLayout.setJustifyContentMode(JustifyContentMode.EVENLY);


        ComboBox<Location> fromComboBox = createLocationComboBox("Dari");
        ComboBox<Location> toComboBox = createLocationComboBox("Ke");
        DatePicker departureDatePicker = new DatePicker("Tanggal Keberangkatan");
        departureDatePicker.setClearButtonVisible(true);
        DatePicker arrivalDatePicker = new DatePicker("Tanggal Kepulangan");
        arrivalDatePicker.setClearButtonVisible(true);

        Button searchButton = new Button("Search", VaadinIcon.SEARCH.create());
        searchButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Grid<ScheduleDTO> grid = null;
        Grid<ScheduleDTO> finalGrid = grid;
        searchButton.addClickListener(event -> searchFlights(fromComboBox, toComboBox, departureDatePicker, finalGrid));

        // Add components to the layout.
        formLayout.add(fromComboBox, toComboBox, departureDatePicker, arrivalDatePicker, searchButton);

        grid = new Grid<>(ScheduleDTO.class, false);
        setupGrid(grid);

        add(formLayout, grid);
    }

    private ComboBox<Location> createLocationComboBox(String label) {
        ComboBox<Location> comboBox = new ComboBox<>(label);
        comboBox.setItems(locationDao.getAll());
        comboBox.setItemLabelGenerator(Location::getName);
        comboBox.setClearButtonVisible(true);
        return comboBox;
    }

    private void setupGrid(Grid<ScheduleDTO> grid) {
        grid.addColumn(ScheduleDTO::getId).setHeader("id");
        grid.addColumn(ScheduleDTO::getFlightNumber).setHeader("Nomor Pesawat");
        // ... (rest of the grid setup)

        grid.setItemDetailsRenderer(createBookingRenderer());
    }

    private void searchFlights(ComboBox<Location> fromComboBox, ComboBox<Location> toComboBox, DatePicker departureDatePicker, Grid<ScheduleDTO> grid) {
        // Implement search logic and update grid items.
    }

    // ... (rest of the code including CreateBookingFormLayout and createBookingRenderer)

    // Additional helper methods and event handlers can be included as needed.
}