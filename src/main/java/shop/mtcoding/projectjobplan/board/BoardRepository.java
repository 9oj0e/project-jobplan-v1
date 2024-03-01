package shop.mtcoding.projectjobplan.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepository {
    private final EntityManager entityManager;

    @Transactional
    public void save(BoardRequest.SaveDTO requestDTO, Integer userId) {
        String q = """
                INSERT INTO board_tb
                (user_id, title, content, field, position, salary, opening_date, closing_date, created_at)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, now())
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, userId);
        query.setParameter(2, requestDTO.getTitle());
        query.setParameter(3, requestDTO.getContent());
        query.setParameter(4, requestDTO.getField());
        query.setParameter(5, requestDTO.getPosition());
        query.setParameter(6, requestDTO.getSalary());
        query.setParameter(7, requestDTO.getOpeningDate());
        query.setParameter(8, requestDTO.getClosingDate());
    }

    public List<Board> findAll() {
        String q = "select * from board_tb order by id desc";
        Query query = entityManager.createNativeQuery(q);

        return (List<Board>) query.getResultList();

    }

    public Board findById(Integer id) {
        String q = "select * from board_tb where id = ? order by id desc";
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, id);

        return (Board) query.getSingleResult();
    }

    @Transactional
    public void updateById(BoardRequest.UpdateDTO requestDTO, Integer id) {
        String q = """
                UPDATE board_tb
                SET
                title = ?,
                content = ?,
                field = ?,
                position = ?,
                salary = ?,
                opening_date = ?,
                closing_date = ?
                WHERE id = ?
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, requestDTO.getTitle());
        query.setParameter(2, requestDTO.getContent());
        query.setParameter(3, requestDTO.getField());
        query.setParameter(4, requestDTO.getPosition());
        query.setParameter(5, requestDTO.getSalary());
        query.setParameter(6, requestDTO.getOpeningDate());
        query.setParameter(7, requestDTO.getClosingDate());
        query.setParameter(8, id);

    }

    @Transactional
    public void deleteById(Integer id) {
        String q = "DELETE FROM board_tb WHERE id = ?";
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, id);
    }
}
