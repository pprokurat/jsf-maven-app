/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pprokurat.jsfproject.web.model;

import com.pprokurat.jsfproject.hibernate.entity.ScreeningEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.primefaces.event.SelectEvent;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author patry
 */
@Named("screeningsBean")
@SessionScoped
public class ScreeningsBean implements Serializable {

    private List<ScreeningEntity> screeningsList;
    private Date datetime = new Date();
    private java.sql.Date date = new java.sql.Date(datetime.getTime());
    private TimeZone timeZone = TimeZone.getTimeZone("Europe/Warsaw");


    @PostConstruct
    public void loadScreenings(){

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<ScreeningEntity> criteria = builder.createQuery(ScreeningEntity.class);
        Root<ScreeningEntity> root = criteria.from(ScreeningEntity.class);

        criteria.select(root).where(session.getCriteriaBuilder().equal(root.get("date"),date));

        TypedQuery<ScreeningEntity> query = session.createQuery(criteria);

        screeningsList = query.getResultList();

        session.close();
    }

    public void dateSelectedAction(SelectEvent event){
        datetime = (Date) event.getObject();
        date = new java.sql.Date(datetime.getTime());
        loadScreenings();
    }

    public String goToIndex(){
        return "index.xhtml?faces-redirect=true";
    }

    /**
     * @return the screeningsList
     */
    public List<ScreeningEntity> getScreeningsList() {
        return screeningsList;
    }

    /**
     * @param screeningsList the screeningsList to set
     */
    public void setScreeningsList(List<ScreeningEntity> screeningsList) {
        this.screeningsList = screeningsList;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }


}