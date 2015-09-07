package com.pabili.postings.dto;

import com.pabili.commons.dto.posting.PostingInfo;

/**
 * @author mbmartinez
 */
public class BuyRequestInfo {

    private String title;
    private String description;
    private PostingInfo posting;
    private int quantity;

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
    public PostingInfo getPosting() {
        return posting;
    }
    public void setPosting(PostingInfo posting) {
        this.posting = posting;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
