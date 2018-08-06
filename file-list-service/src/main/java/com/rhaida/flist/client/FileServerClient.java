package com.rhaida.flist.client;

import com.rhaida.flist.dto.UserFile;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created on 05.08.2018
 *
 * @author Roman Hayda
 */
@FeignClient(name = "file-service")
public interface FileServerClient {

    @GetMapping(path = "/files")
    public List<UserFile> getAllFiles();
}
