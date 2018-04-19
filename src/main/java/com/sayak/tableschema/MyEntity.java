package com.sayak.tableschema;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bot")
public class MyEntity extends TableEntity {
    private String botName;
    private String botDescription;

    public MyEntity(boolean deleted, String botName, String botDescription) {
        super(deleted);
        this.botName = botName;
        this.botDescription = botDescription;
    }

    public String getBotName() {
        return botName;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public String getBotDescription() {
        return botDescription;
    }

    public void setBotDescription(String botDescription) {
        this.botDescription = botDescription;
    }
}