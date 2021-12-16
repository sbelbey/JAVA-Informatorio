package com.informatorio.trabajoFinal.Repository;

import com.informatorio.trabajoFinal.Entity.Urls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlsRepository extends JpaRepository<Urls, Long> {
}
