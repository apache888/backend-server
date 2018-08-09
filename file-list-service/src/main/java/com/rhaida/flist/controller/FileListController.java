package com.rhaida.flist.controller;

import com.rhaida.flist.client.FileServerClient;
import com.rhaida.flist.dto.UserFile;
import com.rhaida.flist.service.FileListService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping(path = "/file-list")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class FileListController {

    private FileListService fileListService;

    @GetMapping(path = "")
    public List<UserFile> getList() {
        List<UserFile> allFiles = fileListService.getAllFiles();
        return allFiles;
    }
}
