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

import java.io.File;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author patry
 */
@Named("showTimesBean")
@ApplicationScoped
public class ShowTimesBean implements Serializable {

    private List<ShowtimeEntity> showsList;
    
    @PostConstruct
    public void loadShows(){

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaQuery<ShowtimeEntity> criteriaQuery = session.getCriteriaBuilder().createQuery(ShowtimeEntity.class);
        criteriaQuery.from(ShowtimeEntity.class);

        showsList = session.createQuery(criteriaQuery).getResultList();
        session.close();
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
    
}
