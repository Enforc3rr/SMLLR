package com.shrbsrv.sharebinservice.service;

import com.shrbsrv.sharebinservice.dao.ShareBinRepo;
import com.shrbsrv.sharebinservice.entity.ShareBinEntity;
import com.shrbsrv.sharebinservice.keyUtil.KeyUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareBinServiceImplementation implements ShareBinService{
    @Autowired
    ShareBinRepo shareBinRepo;
    @Autowired
    KeyUtilService keyUtilService;

    @Override
    public String createShareBin(String shareBinTitle, String shareBinCode) {
        ShareBinEntity shareBinEntity = new ShareBinEntity(shareBinTitle,shareBinCode);
        shareBinEntity.setShareBinKey(keyUtilService.gettingKeyFromKeyGenerationService());
        shareBinRepo.save(shareBinEntity);

        return shareBinEntity.getShareBinKey();
    }
    @Override
    public ShareBinEntity getShareBin(String shareBinKey) {
        return shareBinRepo.findShareBin(shareBinKey);
    }

    @Override
    public void incrementShareBinClicks(ShareBinEntity shareBinEntity) {
        shareBinEntity.setNumberOfClicks(shareBinEntity.getNumberOfClicks()+1);
        shareBinRepo.save(shareBinEntity);
    }

    @Override
    public void deleteShareBinCode(String shareBinKey) {
        keyUtilService.updatingDeletedKeyStatus(shareBinKey);
        shareBinRepo.deleteById(shareBinKey);
    }
}
