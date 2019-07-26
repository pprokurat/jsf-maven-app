/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pprokurat.jsfproject.web.model;

import com.pprokurat.jsfproject.hibernate.entity.ShowtimeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.primefaces.event.SelectEvent;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author patry
 */
@Named("showTimesBean")
@SessionScoped
public class ShowTimesBean implements Serializable {

    private List<ShowtimeEntity> showsList;
    private Date datetime = new Date();
    private java.sql.Date date = new java.sql.Date(datetime.getTime());


    @PostConstruct
    public void loadShows(){

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaQuery<ShowtimeEntity> criteriaQuery = session.getCriteriaBuilder().createQuery(ShowtimeEntity.class);
        criteriaQuery.from(ShowtimeEntity.class);

        showsList = session.createQuery(criteriaQuery).getResultList();
        session.close();
    }

    public void dateSelectedAction(SelectEvent event){
        datetime = (Date) event.getObject();
        date = new java.sql.Date(datetime.getTime());
        System.out.println("Date Selected Is :: "+date);
    }

    /**
     * @return the showsList
     */
    public List<ShowtimeEntity> getShowsList() {
        return showsList;
    }

    /**
     * @param showsList the showsList to set
     */
    public void setShowsList(List<ShowtimeEntity> showsList) {
        this.showsList = showsList;
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


}
