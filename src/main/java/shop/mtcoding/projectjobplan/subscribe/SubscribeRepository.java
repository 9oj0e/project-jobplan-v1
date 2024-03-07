package shop.mtcoding.projectjobplan.subscribe;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class SubscribeRepository {
    private final EntityManager entityManager;

    public int uploadByBoardId(
            int boardId,
            SubscribeRequest.UploadByBoardIdDTO requestDTO) {
        String q = """
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, boardId);

        return query.executeUpdate();
    }

    public int uploadByResumeId(
            int resumeId,
            SubscribeRequest.UploadByResumeIdDTO requestDTO) {
        String q = """
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, resumeId);

        return query.executeUpdate();
    }

    public List<SubscribeResponse.ToUserDTO> findByUserId(int sessionUserId) {
        String q = """
                """;
        Query query = entityManager.createNativeQuery(q);

        return null;
    }

    public List<SubscribeResponse.ToEmployerDTO> findByEmployerId(int sessionUserId) {
        String q = """
                """;
        Query query = entityManager.createNativeQuery(q);

        return null;
    }

    public int deleteByBoardId(int boardId) {
        String q = """
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, boardId);

        return query.executeUpdate();
    }

    public int deleteByResumeId(int resumeId) {
        String q = """
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, resumeId);

        return query.executeUpdate();
    }
}
