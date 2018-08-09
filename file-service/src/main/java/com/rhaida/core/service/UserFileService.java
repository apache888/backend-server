package com.rhaida.core.service;

import com.rhaida.core.domain.UserFile;
import com.rhaida.core.dto.RenameDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Created on 04.08.2018
 *
 * @author Roman Hayda
 */
public interface UserFileService {

    UserFile save(UserFile file);

    Optional<UserFile> rename(UUID id, RenameDto newName);

    boolean delete(UserFile file);

    List<UserFile> getAll();

    Optional<UserFile> getUserFileById(UUID id);
}
