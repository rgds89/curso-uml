package com.roger.cursomc.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer status;
    private String mg;
    private Long timeStamp;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public StandardError(Integer status, String mg, Long timeStamp) {
        this.status = status;
        this.mg = mg;
        this.timeStamp = timeStamp;
    }
}
