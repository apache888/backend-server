package com.rhaida.flist.service;

import com.rhaida.flist.client.FileServerClient;
import com.rhaida.flist.dto.UserFile;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class FileListServiceImpl implements FileListService {
    private FileServerClient fileServerClient;

    @Override
    public List<UserFile> getAllFiles() {
        List<UserFile> allFiles = fileServerClient.getAllFiles();
        allFiles.sort(Comparator.comparing(UserFile::getFilename));
        return allFiles;
    }
}
