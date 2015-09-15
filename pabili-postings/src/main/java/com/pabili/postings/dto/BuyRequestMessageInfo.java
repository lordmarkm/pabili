package com.pabili.postings.dto;

import com.pabili.commons.dto.BaseDto;

/**
 * @author Mark Martinez, create Sep 14, 2015
 */
public class BuyRequestMessageInfo extends BaseDto {

    private String sender;
    private String gopher;
    private String message;

    @Override
    public String toString() {
        return super.tsc()
                .append("sender", sender)
                .append("gopher", gopher)
                .append("message", message)
                .toString();
    }

    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getGopher() {
        return gopher;
    }
    public void setGopher(String gopher) {
        this.gopher = gopher;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
