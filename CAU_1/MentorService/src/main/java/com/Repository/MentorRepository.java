package com.MentorService.MentorService.Repository;

import com.MentorService.MentorService.entities.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    List<Mentor> findAllByWeight(String weight);

    List<Mentor> findAllByName(String name);

    List<Mentor> findAllByAddress(String address);
}
