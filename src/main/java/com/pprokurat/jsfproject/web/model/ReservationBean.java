package com.pprokurat.jsfproject.web.model;

import com.pprokurat.jsfproject.hibernate.entity.ScreeningEntity;
import com.pprokurat.jsfproject.hibernate.entity.ScreeningSeatEntity;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Named("reservationBean")
@SessionScoped
public class ReservationBean implements Serializable {

    private String email;
    private String name;
    private String phoneNumber;
    private ScreeningEntity screening;
    private int columns;
    private int rows;
    private int size;
    private Date date;
    private List<ScreeningSeatEntity> seatsList = new ArrayList<>();
    private List<ScreeningSeatEntity> selectedSeatsList = new ArrayList<>();
    private List<Boolean> checkedSeatsList = new ArrayList<>();
    private List<Integer> iterationList = new ArrayList<>();
    private HashSet<Integer> uniqueRowNumber = new HashSet<Integer>();


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public ScreeningEntity getScreening() {
        return screening;
    }

    public void setScreening(ScreeningEntity screening) {
        this.screening = screening;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() { return rows; }

    public void setRows(int rows) { this.rows = rows; }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public List<ScreeningSeatEntity> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(List<ScreeningSeatEntity> seatsList) {
        this.seatsList = seatsList;
    }

    public List<ScreeningSeatEntity> getSelectedSeatsList() { return selectedSeatsList; }

    public void setSelectedSeatsList(List<ScreeningSeatEntity> selectedSeatsList) { this.selectedSeatsList = selectedSeatsList; }

    public List<Boolean> getCheckedSeatsList() { return checkedSeatsList; }

    public void setCheckedSeatsList(List<Boolean> checkedSeatsList) { this.checkedSeatsList = checkedSeatsList; }

    public List<Integer> getIterationList() { return iterationList; }

    public void setIterationList(List<Integer> iterationList) { this.iterationList = iterationList; }

    public HashSet<Integer> getUniqueRowNumber() { return uniqueRowNumber; }

    public void setUniqueRowNumber(HashSet<Integer> uniqueRowNumber) { this.uniqueRowNumber = uniqueRowNumber; }


    public String chooseScreening(ScreeningEntity screening) {
        this.screening = screening;

        date = new Date(screening.getDate().getTime());

        loadSeats();

        countColumns();
        countRows();

        size = seatsList.size();

        uniqueRowNumber = new HashSet<Integer>();
        checkedSeatsList = new ArrayList<>();
        selectedSeatsList = new ArrayList<>();
        iterationList = new ArrayList<>();
        populateCheckedSeatsList();

        return "reservation.xhtml?faces-redirect=true";
    }

    private void loadSeats() {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<ScreeningSeatEntity> criteria = builder.createQuery(ScreeningSeatEntity.class);
        Root<ScreeningSeatEntity> root = criteria.from(ScreeningSeatEntity.class);

        criteria.select(root).where(session.getCriteriaBuilder().equal(root.get("screeningId"), screening.getScreeningId()));

        TypedQuery<ScreeningSeatEntity> query = session.createQuery(criteria);

        seatsList = query.getResultList();

        Collections.sort(seatsList);

        session.close();
    }
    
    private void countColumns() {

        HashSet<Integer> uniqueSeatNumber = new HashSet<Integer>();

        for (ScreeningSeatEntity seat : seatsList
             ) {
            uniqueSeatNumber.add(seat.getRoomSeatId().getSeatNumber());
        }

        columns = uniqueSeatNumber.size();
        
    }

    private void countRows() {

        for (ScreeningSeatEntity seat : seatsList
        ) {
            uniqueRowNumber.add(seat.getRoomSeatId().getRowNumber());
        }

        rows = uniqueRowNumber.size();

    }

    private void populateCheckedSeatsList() {

        for (ScreeningSeatEntity seat : seatsList
        ) {
            checkedSeatsList.add(false);
        }

        Integer iterator = 0;

        for (ScreeningSeatEntity seat : seatsList
        ) {
            iterationList.add(iterator);
            iterator++;
        }

    }

    public void updateSelectedSeatsList() {

        int index = 0;
        for(Boolean checked : checkedSeatsList
        ) {
            if(checked == true && !selectedSeatsList.contains(seatsList.get(index))) {
                selectedSeatsList.add(seatsList.get(index));
            }
            else if(checked == false && selectedSeatsList.contains(seatsList.get(index))) {
                selectedSeatsList.remove(seatsList.get(index));
            }

            index++;
        }

        Collections.sort(selectedSeatsList);

    }

    public boolean isReserved(Integer seatIndex) {

        if(seatsList.get(seatIndex).getScreeningSeatStatus() == 'R' || seatsList.get(seatIndex).getScreeningSeatStatus() == 'S') {
            return true;
        }
        else {
            return false;
        }
    }

    public void makeReservation() {

    }

    public void buyTickets() {

    }
}
