package com.shrbsrv.sharebinservice.controller;

import com.shrbsrv.sharebinservice.entity.ShareBinEntity;
import com.shrbsrv.sharebinservice.service.ShareBinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/sharebin")
@CrossOrigin(origins = "http://localhost:3000")
public class ShareBinController {

    @Autowired
    ShareBinService shareBinService;

    @PostMapping(value = "/create",consumes = "multipart/form-data")
    public ResponseEntity<?> createShareBin(@RequestPart("shareBinTitle") String shareBinTitle
            , @RequestPart("shareBinCode") String shareBinCode){
        return new ResponseEntity<>(shareBinService.createShareBin(shareBinTitle,shareBinCode),HttpStatus.CREATED);
    }

    @GetMapping("/get/{key}")
    public ResponseEntity<?> getShareBin(@PathVariable("key") String key){
        ShareBinEntity shareBinEntity = shareBinService.getShareBin(key);
        if(shareBinEntity!=null){
            CompletableFuture.runAsync(()->{
                shareBinService.incrementShareBinClicks(shareBinEntity);
            });
            if(shareBinEntity.getNumberOfClicks() < 9){
                return new ResponseEntity<>(shareBinEntity,HttpStatus.OK);
            }else{
                shareBinService.deleteShareBinCode(shareBinEntity.getShareBinKey());
                return new ResponseEntity<>(shareBinEntity
                        , HttpStatus.OK);
            }
        }else{
            return new ResponseEntity<>(new ShareBinEntity("Wrong Key word/Click Limit Exceeded"
                    , "# ERROR \n You've Typed wrong Key word \n # OR \n Click Limit Exceeded"),HttpStatus.NOT_FOUND);
        }
    }
}
