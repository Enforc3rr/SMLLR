package com.shrbsrv.sharebinservice.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sharebin")
public class ShareBinEntity {
    @Id
    @Column(name = "shareBinKey")
    private String shareBinKey;

    @Column(name="shareBinTitle")
    private String shareBinTitle;

    @Column(name = "shareBinCode")
    private String shareBinCode;

    @Column(name = "numberOfClicks")
    private int numberOfClicks;

    public ShareBinEntity() {
    }

    public ShareBinEntity(String shareBinTitle, String shareBinCode) {
        this.shareBinTitle = shareBinTitle;
        this.shareBinCode = shareBinCode;
    }

    public ShareBinEntity(String shareBinTitle, String shareBinCode, int numberOfClicks) {
        this.shareBinTitle = shareBinTitle;
        this.shareBinCode = shareBinCode;
        this.numberOfClicks = numberOfClicks;
    }

    public String getShareBinKey() {
        return shareBinKey;
    }

    public void setShareBinKey(String shareBinKey) {
        this.shareBinKey = shareBinKey;
    }

    public String getShareBinTitle() {
        return shareBinTitle;
    }

    public void setShareBinTitle(String shareBinTitle) {
        this.shareBinTitle = shareBinTitle;
    }

    public String getShareBinCode() {
        return shareBinCode;
    }

    public void setShareBinCode(String shareBinCode) {
        this.shareBinCode = shareBinCode;
    }


    public int getNumberOfClicks() {
        return numberOfClicks;
    }

    public void setNumberOfClicks(int numberOfClicks) {
        this.numberOfClicks = numberOfClicks;
    }

    @Override
    public String toString() {
        return "ShareBinEntity{" +
                "shareBinKey='" + shareBinKey + '\'' +
                ", shareBinTitle='" + shareBinTitle + '\'' +
                ", shareBinCode='" + shareBinCode + '\'' +
                '}';
    }
}
