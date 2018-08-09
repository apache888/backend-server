package com.rhaida.flist.service;

import com.rhaida.flist.dto.UserFile;

import java.util.List;

/**
 * Created on 05.08.2018
 *
 * @author Roman Hayda
 */
public interface FileListService {
    List<UserFile> getAllFiles();
}
