package com.rhaida.core.service.impl;

import com.rhaida.core.domain.UserFile;
import com.rhaida.core.repository.UserFileRepository;
import com.rhaida.core.service.UserFileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created on 04.08.2018
 *
 * @author Roman Hayda
 */
@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserFileServiceImpl implements UserFileService {

    private UserFileRepository fileRepository;

    @Override
    public UserFile save(UserFile file) {
        return fileRepository.save(file);
    }

    @Override
    public Optional<UserFile> rename(UUID id, Map<String, String> changes) {
        String newName = changes.get("filename");
        if (StringUtils.isEmpty(newName)) {
            return Optional.empty();
        }

        Optional<UserFile> stored = fileRepository.findById(id);
        if (stored.isPresent()) {
            UserFile file = stored.get();
            file.setFileName(newName);
            return Optional.of(fileRepository.save(file));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(UserFile file) {
        Optional<UserFile> oStored = fileRepository.findById(file.getId());
        if (oStored.isPresent()) {
            fileRepository.delete(oStored.get());
            return true;
        }
        return false;
    }

    @Override
    public List<UserFile> getAll() {
        return fileRepository.findAll();
    }

    @Override
    public Optional<UserFile> getUserFileById(UUID id) {
        return fileRepository.findById(id);
    }
}
