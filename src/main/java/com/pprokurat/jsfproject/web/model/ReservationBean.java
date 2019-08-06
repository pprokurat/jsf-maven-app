package com.pprokurat.jsfproject.web.model;

import com.pprokurat.jsfproject.hibernate.entity.ScreeningEntity;
import com.pprokurat.jsfproject.hibernate.entity.ScreeningSeatEntity;
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
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

@Named("reservationBean")
@SessionScoped
public class ReservationBean implements Serializable {

    private String email;
    private ScreeningEntity screening;
    private int columns;
    private int size;
    private Locale locale = new Locale("pl", "pl");
    private Date date;
    private List<ScreeningSeatEntity> seatsList;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ScreeningSeatEntity> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(List<ScreeningSeatEntity> seatsList) {
        this.seatsList = seatsList;
    }


    public String chooseScreening(ScreeningEntity screening) {
        this.screening = screening;

        date = new Date(screening.getDate().getTime());

        loadSeats();

        countColumns();

        size = seatsList.size();

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

    public boolean isReserved(ScreeningSeatEntity seat) {

        if(seat.getScreeningSeatStatus() == 'R' || seat.getScreeningSeatStatus() == 'S') {
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
