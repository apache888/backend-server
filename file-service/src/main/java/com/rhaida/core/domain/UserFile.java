package com.rhaida.core.domain;

import com.datastax.driver.core.DataType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.time.Instant;
import java.util.UUID;

/**
 * Created on 04.08.2018
 *
 * @author Roman Hayda
 */
@Table
@Builder
@NoArgsConstructor
@Data
public class UserFile {

    @PrimaryKey(value = "id")
    private UUID id;

    @Column(value = "file_name")
    private String fileName;

    @Column
    private String extension;

    @Column
    @CassandraType(type = DataType.Name.BLOB)
    @JsonIgnore
    private byte[] content;

    @Column
    private Long size;

    @Column("upload_time")
    private Instant uploadTime;
}
