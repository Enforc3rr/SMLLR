package com.shrbsrv.sharebinservice.dto;

import com.shrbsrv.sharebinservice.entity.ShareBinEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareBinRepo extends CrudRepository<ShareBinEntity, String> {
    @Query(nativeQuery = true , value = "SELECT * FROM SHARE_BIN_ENTITY WHERE SHARE_BIN_KEY=?1")
    ShareBinEntity findShareBin(String key);
}
