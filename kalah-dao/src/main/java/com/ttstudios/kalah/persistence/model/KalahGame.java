package com.ttstudios.kalah.persistence.model;

import com.querydsl.core.annotations.QueryEntity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@QueryEntity
@Document
public class KalahGame implements Serializable{

    private static final long serialVersionUID = -3900142948363649504L;

    @Id
    private ObjectId id;

    private String title;

    private User player1;

    private User player2;

    public KalahGame() {
        super();
    }

    public KalahGame( String title, User player1, User player2 ) {
        super();
        this.title = title;
        this.player1 = player1;
        this.player2 = player2;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId( ObjectId id ) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public User getPlayer1() {
        return player1;
    }

    public void setPlayer1( User player1 ) {
        this.player1 = player1;
    }

    public User getPlayer2() {
        return player2;
    }

    public void setPlayer2( User player2 ) {
        this.player2 = player2;
    }

    @Override
    public String toString() {
        return "KalahGame [id=" + id + ", title=" + title + ", player1=" + player1 + ", player2=" + player2 + "]";
    }

}
