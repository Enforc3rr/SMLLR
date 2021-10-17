package com.shrbsrv.sharebinservice.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShareBinEntity {
    @Id
    private String shareBinKey;
    private String shareBinTitle;
    private String shareBinCode;

    public ShareBinEntity() {
    }

    public ShareBinEntity(String shareBinTitle, String shareBinCode) {
        this.shareBinTitle = shareBinTitle;
        this.shareBinCode = shareBinCode;
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


    @Override
    public String toString() {
        return "ShareBinEntity{" +
                "shareBinKey='" + shareBinKey + '\'' +
                ", shareBinTitle='" + shareBinTitle + '\'' +
                ", shareBinCode='" + shareBinCode + '\'' +
                '}';
    }
}
