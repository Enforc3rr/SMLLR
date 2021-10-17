package com.shrbsrv.sharebinservice.service;

import com.shrbsrv.sharebinservice.dto.ShareBinRepo;
import com.shrbsrv.sharebinservice.entity.ShareBinEntity;
import com.shrbsrv.sharebinservice.util.KeyUtilService;
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
}
