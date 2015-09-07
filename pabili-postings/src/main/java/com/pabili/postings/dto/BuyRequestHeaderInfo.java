package com.pabili.postings.dto;

import java.util.List;

import com.pabili.commons.dto.BaseDto;

/**
 * @author mbmartinez
 */
public class BuyRequestHeaderInfo extends BaseDto {

    private String title;
    private String description;
    private List<BuyRequestInfo> buyRequests;

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

}
