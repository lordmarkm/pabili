package com.pabili.commons.dto;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
public class Displayable extends BaseDto {

    protected String title;
    protected String description;
    protected String imageUrl;
    protected String albumUrl;

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
    public String getAlbumUrl() {
        return albumUrl;
    }
    public void setAlbumUrl(String albumUrl) {
        this.albumUrl = albumUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
