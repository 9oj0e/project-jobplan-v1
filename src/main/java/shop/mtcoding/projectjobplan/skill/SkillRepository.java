package shop.mtcoding.projectjobplan.skill;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SkillRepository {

    private final EntityManager entityManager;
}
