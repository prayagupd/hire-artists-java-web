package com.hireartists.domain;

/**
 * Created by prayagupd
 * on 7/12/15.
 */

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Event")
public class Event extends AbstractEntity<Long> {

    private String name;

//    @Basic
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date from;
//
//    @Basic
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date to;

    @ManyToOne
    private EventOrganiser eventOrganiser;

    @ManyToMany(mappedBy = "events", fetch = FetchType.LAZY)
    public List<Artist> artists = new ArrayList<Artist>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Date getFrom() {
//        return from;
//    }
//
//    public void setFrom(Date from) {
//        this.from = from;
//    }
//
//    public Date getTo() {
//        return to;
//    }
//
//    public void setTo(Date to) {
//        this.to = to;
//    }

    public EventOrganiser getEventOrganiser() {
        return eventOrganiser;
    }

    public void setEventOrganiser(EventOrganiser eventOrganiser) {
        this.eventOrganiser = eventOrganiser;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }
}
