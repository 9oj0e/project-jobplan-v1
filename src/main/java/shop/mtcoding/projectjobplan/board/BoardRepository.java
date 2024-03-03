package shop.mtcoding.projectjobplan.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.projectjobplan._core.Constant;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Repository
public class BoardRepository {
    private final EntityManager entityManager;



    public List<Board> findAll(int page){
        int value = page * Constant.PAGING_COUNT;
        /* RJS
        String q = """
            SELECT b.id, b.user_id, b.title, b.content, b.field, b.position, b.salary, b.opening_date, b.closing_date, b.created_at, u.username, u.address, u.is_employer, u.business_name FROM board_tb b INNER JOIN user_tb u ON b.user_id = u.id WHERE u.is_employer = true ORDER BY b.id DESC LIMIT ?,?;
                    """;
        */
        String q = """
            SELECT * FROM board_tb order by id DESC LIMIT ?,?;
                    """;
        Query query = entityManager.createNativeQuery(q, Board.class);
        query.setParameter(1,value);
        query.setParameter(2,Constant.PAGING_COUNT);

        return query.getResultList();
    }


    public List<BoardResponse.boardAndUserDTO> findByBoardtbAndUsertb(){
        String q = """
                SELECT b.id,b.user_id, b.title, b.content,b.field,b.position,b.salary,b.opening_date,b.closing_date,b.created_at, u.username,u.address,u.is_employer,u.business_name from board_tb b inner join user_tb u on b.user_id = u.id  order by id desc;
                """;
        Query query = entityManager.createNativeQuery(q);
        List<Object[]> results = query.getResultList();
        List<BoardResponse.boardAndUserDTO> responseDTO = new ArrayList<>();

        for(Object[] result :results){

            BoardResponse.boardAndUserDTO dto = new BoardResponse.boardAndUserDTO();
            dto.setId((Integer) result[0]);
            dto.setUserId((Integer) result[1]);
            dto.setTitle((String) result[2]);
            dto.setContent((String) result[3]);
            dto.setField((String) result[4]);
            dto.setPosition((String) result[5]);
            dto.setSalary((String) result[6]);
            dto.setOpeningDate((Timestamp) result[7]);
            dto.setClosingDate((Timestamp) result[8]);
            dto.setCreatedAt((Timestamp) result[9]);
            dto.setUsername((String) result[10]);
            dto.setAddress((String) result[11]);
            dto.setEmployer((boolean) result[12]);
            dto.setBusinessName((String) result[13]);



            responseDTO.add(dto);
        }
        return responseDTO;

    }


    @Transactional
    public Integer save(BoardRequest.SaveDTO requestDTO, Integer userId) {
        String q = """
                INSERT INTO board_tb
                (user_id, title, content, address, field, position, salary, opening_date, closing_date, created_at)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, now())
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, userId);
        query.setParameter(2, requestDTO.getTitle());
        query.setParameter(3, requestDTO.getContent());
        query.setParameter(4, requestDTO.getAddress());
        query.setParameter(5, requestDTO.getField());
        query.setParameter(6, requestDTO.getPosition());
        query.setParameter(7, requestDTO.getSalary());

        // String -> LocalDate -> Timestamp
        LocalDate opening = LocalDate.parse(requestDTO.getOpeningDate());
        LocalDate closing = LocalDate.parse(requestDTO.getClosingDate());
        Timestamp openingDate = Timestamp.valueOf(opening.atStartOfDay());
        Timestamp closingDate = Timestamp.valueOf(closing.atStartOfDay());
        query.setParameter(8, openingDate);
        query.setParameter(9, closingDate);

        return query.executeUpdate(); // 영향 받은 행
    }

    public List<Board> findAll() {
        String q = "select * from board_tb order by id desc";
        Query query = entityManager.createNativeQuery(q, Board.class);

        return (List<Board>) query.getResultList();

    }

    public Board findById(Integer id) {
        String q = "select * from board_tb where id = ? order by id desc";
        Query query = entityManager.createNativeQuery(q, Board.class);
        query.setParameter(1, id);

        return (Board) query.getSingleResult();
    }

    @Transactional
    public Integer updateById(BoardRequest.UpdateDTO requestDTO, Integer id) {
        String q = """
                UPDATE board_tb
                SET
                title = ?,
                content = ?,
                address = ?,
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
        query.setParameter(3, requestDTO.getAddress());
        query.setParameter(4, requestDTO.getField());
        query.setParameter(5, requestDTO.getPosition());
        query.setParameter(6, requestDTO.getSalary());

        // String -> LocalDate -> Timestamp
        LocalDate opening = LocalDate.parse(requestDTO.getOpeningDate());
        LocalDate closing = LocalDate.parse(requestDTO.getClosingDate());
        Timestamp openingDate = Timestamp.valueOf(opening.atStartOfDay());
        Timestamp closingDate = Timestamp.valueOf(closing.atStartOfDay());
        query.setParameter(7, openingDate);
        query.setParameter(8, closingDate);

        // where clause
        query.setParameter(9, id);

        return query.executeUpdate(); // 영향 받은 행
    }

    @Transactional
    public Integer deleteById(Integer id) {
        String q = "DELETE FROM board_tb WHERE id = ?";
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, id);

        return query.executeUpdate(); // 영향 받은 행
    }



    public int count() {
        String q = """
                SELECT COUNT(*) FROM board_tb;
                """;
        Query query = entityManager.createNativeQuery(q);
        Long count = (Long) query.getSingleResult();
        return count.intValue();

    }
}
