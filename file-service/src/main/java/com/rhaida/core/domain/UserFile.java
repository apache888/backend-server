package com.rhaida.core.domain;

import com.datastax.driver.core.DataType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

/**
 * Created on 04.08.2018
 *
 * @author Roman Hayda
 */
@Table
@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFile {

    @PrimaryKeyColumn(name = "id", ordinal = 0)
    private UUID id;

    @PrimaryKeyColumn(name = "fileName", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String fileName;

    @Column
    private String extension;

    @Column
    @CassandraType(type = DataType.Name.BLOB)
    @JsonIgnore
    private byte[] content;

    @Column
    private Long size;

    @Column
    private Instant uploadTime;
}
