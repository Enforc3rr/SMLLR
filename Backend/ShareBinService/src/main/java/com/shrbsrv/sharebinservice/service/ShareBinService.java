package com.shrbsrv.sharebinservice.service;

import com.shrbsrv.sharebinservice.entity.ShareBinEntity;
import org.springframework.stereotype.Service;

@Service
public interface ShareBinService {
    String createShareBin(String shareBinTitle , String shareBinCode);
    ShareBinEntity getShareBin(String shareBinKey);
}
