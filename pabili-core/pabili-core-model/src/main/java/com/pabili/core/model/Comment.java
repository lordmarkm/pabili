package com.pabili.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pabili.commons.comments.CommentableType;
import com.pabili.core.model.base.BaseEntity;
import com.pabili.core.model.user.UserProfile;

@Entity(name = "comment")
public class Comment extends BaseEntity {

    @Column(name = "parent_id", nullable = false)
    private long parentId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "parent_type", nullable = false)
    private CommentableType parentType;

    @ManyToOne
    @JoinColumn(name = "poster_id")
    private UserProfile poster;

    @Column(name = "text", length = 2000)
    private String text;

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public CommentableType getParentType() {
        return parentType;
    }

    public void setParentType(CommentableType parentType) {
        this.parentType = parentType;
    }

    public UserProfile getPoster() {
        return poster;
    }

    public void setPoster(UserProfile poster) {
        this.poster = poster;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
