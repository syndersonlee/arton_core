package team.arton.coreserver.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.arton.coreserver.domain.Content;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    Optional<Content> findById(Long id);
    List<Content> findByIdLessThan(Pageable pageable, Long Id);
}


