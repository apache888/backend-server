package com.rhaida.flist.dto;

import lombok.Value;

import java.time.Instant;
import java.util.UUID;

/**
 * Created on 05.08.2018
 *
 * @author Roman Hayda
 */
@Value
public class UserFile {
    private UUID id;

    private String fileName;

    private String extension;

    private Long size;

    private Instant uploadTime;
}
