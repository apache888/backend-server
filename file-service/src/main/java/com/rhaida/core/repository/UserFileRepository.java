package com.rhaida.core.repository;

import com.rhaida.core.domain.UserFile;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created on 04.08.2018
 *
 * @author Roman Hayda
 */
@Repository
public interface UserFileRepository extends CassandraRepository<UserFile, UUID> {

    @Override
    @Query("select * from userfile where id= :id")
    Optional<UserFile> findById(@Param("id") UUID id);
}
