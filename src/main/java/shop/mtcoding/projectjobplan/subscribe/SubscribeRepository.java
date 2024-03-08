package shop.mtcoding.projectjobplan.subscribe;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class SubscribeRepository {
    private final EntityManager entityManager;

    public Subscribe findAllByUserIdResumeId(Integer userId, Integer resumeId){
        String q = "select * from subscribe_tb where user_id = ? and resume_id = ?";
        Query query = entityManager.createNativeQuery(q, Subscribe.class);
        query.setParameter(1, userId);
        query.setParameter(2, resumeId);

        try {
            return (Subscribe)query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Subscribe findAllByUserIdBoardId(Integer userId, Integer boardId){
        String q = "select * from subscribe_tb where user_id = ? and board_id = ?";
        Query query = entityManager.createNativeQuery(q, Subscribe.class);
        query.setParameter(1, userId);
        query.setParameter(2, boardId);

        try {
            return (Subscribe)query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Integer findResumeUserIdByResumeId(int resumeId){
        String q = "select user_id from resume_tb where id = ?";
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, resumeId);

        return (Integer) query.getSingleResult();
    }

    public Integer findBoardUserIdByBoardId(int boardId){
        String q = "select employer_id from board_tb where id = ?";
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, boardId);

        return (Integer) query.getSingleResult();
    }

    @Transactional
    public int uploadByBoardId(int boardId,Integer sessionUserId, Integer boardUserId) {
        String q = """
                insert into subscribe_tb (user_id, board_id, board_user_id, created_at) values(?,?,?, now())
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, sessionUserId);
        query.setParameter(2, boardId);
        query.setParameter(3, boardUserId);

        return query.executeUpdate();
    }

    @Transactional
    public int uploadByResumeId(int resumeId, Integer sessionUserId, Integer resumeUserId) {
        String q = """
                insert into subscribe_tb (user_id, resume_id, resume_user_id, created_at) values(?,?,?, now())
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, sessionUserId);
        query.setParameter(2, resumeId);
        query.setParameter(3, resumeUserId);

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
                select 
                s.resume_id, r.title, u.name from subscribe_tb s, resume_tb r, user_tb u
                where
                s.user_id = ? and r.id = s.resume_id and u.id = s.resume_user_id;
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, sessionUserId);
        List<Object[]> results = query.getResultList();
        List<SubscribeResponse.ToEmployerDTO> responseDTO = new ArrayList<>();
        for (Object[] result : results){
            SubscribeResponse.ToEmployerDTO dto = new SubscribeResponse.ToEmployerDTO();
            dto.setResumeId((Integer) result[0]);
            dto.setTitle((String) result[1]);
            dto.setResumeUsername((String) result[2]);
            responseDTO.add(dto);
        }

        return responseDTO;
    }


    @Transactional
    public int deleteByBoardId(int boardId, Integer sessionUserId) {
        String q = """
                delete from subscribe_tb where board_id = ? and user_id = ?
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, boardId);
        query.setParameter(2, sessionUserId);

        return query.executeUpdate();
    }

    @Transactional
    public int deleteByResumeId(int resumeId, Integer sessionUserId) {
        String q = """
                delete from subscribe_tb where resume_id = ? and user_id = ?
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, resumeId);
        query.setParameter(2, sessionUserId);

        return query.executeUpdate();
    }
}
