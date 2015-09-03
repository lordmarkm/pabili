package com.pabili.core.model.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Mark Martinez, created Sep 3, 2015
 */
@MappedSuperclass
public class BaseImageableEntity extends BaseNamedEntity {

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "album_url")
    private String albumUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAlbumUrl() {
        return albumUrl;
    }

    public void setAlbumUrl(String albumUrl) {
        this.albumUrl = albumUrl;
    }

}
