package com.informatorio.trabajoFinal.Repository;

import com.informatorio.trabajoFinal.Entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Long> {

}
