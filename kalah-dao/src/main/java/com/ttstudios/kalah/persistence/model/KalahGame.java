package com.ttstudios.kalah.persistence.model;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@QueryEntity
@Document
public class KalahGame implements Serializable{

    private static final long serialVersionUID = -3900142948363649504L;

    @Id
    private String id;

    @NotNull
    private String title;

    private String player1;

    private String player2;

    public KalahGame() {
        super();
    }

    public KalahGame( String title, String player1, String player2 ) {
        super();
        this.title = title;
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1( String player1 ) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2( String player2 ) {
        this.player2 = player2;
    }

    @Override
    public String toString() {
        return "KalahGame [id=" + id + ", title=" + title + ", player1=" + player1 + ", player2=" + player2 + "]";
    }

}
