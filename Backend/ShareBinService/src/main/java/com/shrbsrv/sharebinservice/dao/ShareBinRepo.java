package com.shrbsrv.sharebinservice.dao;

import com.shrbsrv.sharebinservice.entity.ShareBinEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareBinRepo extends CrudRepository<ShareBinEntity, String> {
    @Query(nativeQuery = true , value = "SELECT * FROM sharebin WHERE share_bin_key =?1")
    ShareBinEntity findShareBin(String key);

}
