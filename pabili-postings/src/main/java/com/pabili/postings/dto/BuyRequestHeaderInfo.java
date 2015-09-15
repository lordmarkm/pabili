package com.pabili.postings.dto;

import java.util.List;

import org.springframework.core.style.ToStringCreator;

import com.pabili.commons.dto.BaseDto;

/**
 * @author mbmartinez
 */
public class BuyRequestHeaderInfo extends BaseDto {

    private String title;
    private String description;
    private String creator;
    private List<BuyRequestInfo> buyRequests;
    private List<BuyRequestMessageInfo> conversations;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("title", title)
            .append("desc", description)
            .append("owner", creator)
            .append("buy requests", buyRequests)
            .append("conversations", conversations)
            .toString();
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<BuyRequestInfo> getBuyRequests() {
        return buyRequests;
    }
    public void setBuyRequests(List<BuyRequestInfo> buyRequests) {
        this.buyRequests = buyRequests;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<BuyRequestMessageInfo> getConversations() {
        return conversations;
    }

    public void setConversations(List<BuyRequestMessageInfo> conversations) {
        this.conversations = conversations;
    }

}
