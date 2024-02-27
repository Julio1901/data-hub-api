package com.julio.projects.datahub.repositories;

import com.julio.projects.datahub.models.LoginKeeperModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoginKeeperRepository extends JpaRepository<LoginKeeperModel, UUID> {
    LoginKeeperModel findByServiceNameAndOwner(String serviceName, String owner);
}
