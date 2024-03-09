package shop.mtcoding.projectjobplan.rating;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.projectjobplan.user.User;

@Repository
@RequiredArgsConstructor
public class RatingRepository {
    private final EntityManager entityManager;

    @Transactional
    public int upload(int raterId, int subjectId, int rate) {
        String q = "insert into rating_tb (rater_id, subject_id, rate) values (?, ?, ?)";
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, raterId);
        query.setParameter(2, subjectId);
        query.setParameter(3, rate);

        return query.executeUpdate();
    }

    @Transactional
    public Double findAvgRateBySubjectId(int subjectId) {
        Query query = entityManager.createNativeQuery("select avg(rate) from rating_tb where subject_id = ?");
        query.setParameter(1, subjectId);

        return (Double) query.getSingleResult();
    }

    @Transactional
    public Rating findAllBySubjectId(Integer subjectId) {
        Query query = entityManager.createNativeQuery("select * from rating_tb where subjectId = ?", Rating.class);
        query.setParameter(1, subjectId);
      
        return (Rating) query.getSingleResult();
    }
}
