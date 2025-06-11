package org.serratec.backend.repository;

import org.serratec.backend.entity.ObraMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraMaterialRepository extends JpaRepository<ObraMaterial, Long> {}