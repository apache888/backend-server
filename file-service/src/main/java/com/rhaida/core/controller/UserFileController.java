package com.rhaida.core.controller;

import com.rhaida.core.domain.UserFile;
import com.rhaida.core.service.UserFileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Created on 05.08.2018
 *
 * @author Roman Hayda
 */
@RestController
@RequestMapping("/files")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserFileController {

    private UserFileService service;

    @PostMapping(path = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity saveFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        UserFile userFile = UserFile.builder()
                .id(UUID.randomUUID())
                .fileName(multipartFile.getOriginalFilename())
                .extension(multipartFile.getContentType())
                .content(multipartFile.getBytes())
                .size(multipartFile.getSize())
                .uploadTime(Instant.now())
                .build();

        return ResponseEntity.ok(service.save(userFile));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getUserFile(@PathVariable UUID id) {
        Optional<UserFile> oUserFile = service.getUserFileById(id);
        return oUserFile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getAll() {
        List<UserFile> userFiles = service.getAll();
        return ResponseEntity.ok(userFiles);
    }

    @PatchMapping(path = "/{id}/rename")
    public ResponseEntity rename(@RequestBody Map<String, String> changes, @PathVariable UUID id) {
        String newName = changes.get("fileName");
        if (StringUtils.isEmpty(newName)) {
            return ResponseEntity.badRequest().build();
        }
        Optional<UserFile> oUserFile = service.rename(id, newName);
        if (oUserFile.isPresent()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteUserFile(@PathVariable UUID id) {
        Optional<UserFile> oUserFile = service.getUserFileById(id);
        return oUserFile.map(file -> {
            service.delete(file);
            return ResponseEntity.ok().build();
        }).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
