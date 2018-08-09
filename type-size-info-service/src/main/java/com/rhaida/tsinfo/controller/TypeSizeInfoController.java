package com.rhaida.tsinfo.controller;

import com.rhaida.tsinfo.client.FileServiceClient;
import com.rhaida.tsinfo.dto.TypeSizeInfoDto;
import com.rhaida.tsinfo.dto.UserFile;
import com.rhaida.tsinfo.service.TypeSizeInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 05.08.2018
 *
 * @author Roman Hayda
 */
@RestController
@RequestMapping(path = "/type-size-info")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class TypeSizeInfoController {

    private FileServiceClient fileServiceClient;
    private TypeSizeInfoService service;

    @GetMapping(path = "")
    public List<TypeSizeInfoDto> getTypeSizeInfo() {
        List<UserFile> allFiles = fileServiceClient.getAllFiles();
        List<TypeSizeInfoDto> typeSizeInfo = service.getTypeSizeInfo(allFiles);
        return typeSizeInfo;
    }
}
