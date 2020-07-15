package project.classes;

import java.util.Date;

public class History {
    private Date date;
    private String log;


    public String toString(){
        return "history";
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
