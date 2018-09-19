package com.tjx.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


public class EbookEntryEntity implements Serializable{
    private int id;
    private String title;
    private String summary;
    private String uploaduser;
    private Date createdate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    public String getUploaduser() {
        return uploaduser;
    }

    public void setUploaduser(String uploaduser) {
        this.uploaduser = uploaduser;
    }


    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EbookEntryEntity that = (EbookEntryEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (summary != null ? !summary.equals(that.summary) : that.summary != null) return false;
        if (uploaduser != null ? !uploaduser.equals(that.uploaduser) : that.uploaduser != null) return false;
        if (createdate != null ? !createdate.equals(that.createdate) : that.createdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (uploaduser != null ? uploaduser.hashCode() : 0);
        result = 31 * result + (createdate != null ? createdate.hashCode() : 0);
        return result;
    }
}
