package com.rhaida.tsinfo.client;

import com.rhaida.tsinfo.dto.UserFile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * Created on 05.08.2018
 *
 * @author Roman Hayda
 */
@FeignClient(name = "file-service")
public interface FileServiceClient {

    @GetMapping(path = "/files")
    List<UserFile> getAllFiles();
}
