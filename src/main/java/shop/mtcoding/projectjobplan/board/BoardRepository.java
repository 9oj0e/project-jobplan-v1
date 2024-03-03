package shop.mtcoding.projectjobplan.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Repository
public class BoardRepository {
    private final EntityManager entityManager;

    public BoardResponse.BoardDetailDTO detail(int idx) {
        String q = """
                select
                u.address, u.business_name, u.email, u.name, u.phone_number,
                b.id, b.title, b.content, b.field, b.position, b.salary, b.opening_date, b.closing_date, b.user_id
                from user_tb u, board_tb b
                where b.id=? and b.user_id = u.id
                """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, idx);

        Object[] row = (Object[]) query.getSingleResult();

        String address = (String) row[0];
        String businessName = (String) row[1];
        String email = (String) row[2];
        String name = (String) row[3];
        String phoneNumber = (String) row[4];
        Integer id = (Integer) row[5];
        String title = (String) row[6];
        String content = (String) row[7];
        String field = (String) row[8];
        String position = (String) row[9];
        String salary = (String) row[10];
        Timestamp openingDate = (Timestamp) row[11];
        Timestamp closingDate = (Timestamp) row[12];
        Integer userId = (Integer) row[13];

        BoardResponse.BoardDetailDTO boardDetailDTO = new BoardResponse.BoardDetailDTO();
        boardDetailDTO.setAddress(address);
        boardDetailDTO.setBusinessName(businessName);
        boardDetailDTO.setEmail(email);
        boardDetailDTO.setName(name);
        boardDetailDTO.setPhoneNumber(phoneNumber);
        boardDetailDTO.setId(id);
        boardDetailDTO.setTitle(title);
        boardDetailDTO.setContent(content);
        boardDetailDTO.setField(field);
        boardDetailDTO.setPosition(position);
        boardDetailDTO.setSalary(salary);
        boardDetailDTO.setOpeningDate(openingDate);
        boardDetailDTO.setClosingDate(closingDate);
        boardDetailDTO.setUserId(userId);

        return boardDetailDTO;
    }

    public List<BoardResponse.boardAndUserDTO> findByBoardtbAndUsertb(int page) {
        final int COUNT = 10;
        int value = (page - 1) * COUNT;
        String q = """
                SELECT b.id, b.user_id, b.title, b.content, b.field, b.position, b.salary, b.opening_date, b.closing_date, b.created_at, u.username, u.address, u.is_employer, u.business_name FROM board_tb b INNER JOIN user_tb u ON b.user_id = u.id WHERE u.is_employer = true ORDER BY b.id DESC LIMIT ?,?;               
                        """;
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, value);
        query.setParameter(2, COUNT);
        List<Object[]> results = query.getResultList();
        List<BoardResponse.boardAndUserDTO> responseDTO = new ArrayList<>();

        for (Object[] result : results) {

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

    public List<BoardResponse.boardAndUserDTO> findByBoardtbAndUsertb() {
        String q = """
                select b.id,b.user_id, b.title, b.content,b.field,b.position,b.salary,b.opening_date,b.closing_date,b.created_at, u.username,u.address,u.is_employer,u.business_name from board_tb b inner join user_tb u on b.user_id = u.id  order by id desc;
                """;
        Query query = entityManager.createNativeQuery(q);
        List<Object[]> results = query.getResultList();
        List<BoardResponse.boardAndUserDTO> responseDTO = new ArrayList<>();

        for (Object[] result : results) {

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

        // String -> LocalData -> Timestamp
        LocalDate opening = LocalDate.parse(requestDTO.getOpeningDate());
        LocalDate closing = LocalDate.parse(requestDTO.getClosingDate());
        Timestamp openingDate = Timestamp.valueOf(opening.atStartOfDay());
        Timestamp closingDate = Timestamp.valueOf(closing.atStartOfDay());

        query.setParameter(7, openingDate);
        query.setParameter(8, closingDate);

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

        // String -> LocalData -> Timestamp
        LocalDate opening = LocalDate.parse(requestDTO.getOpeningDate());
        LocalDate closing = LocalDate.parse(requestDTO.getClosingDate());
        Timestamp openingDate = Timestamp.valueOf(opening.atStartOfDay());
        Timestamp closingDate = Timestamp.valueOf(closing.atStartOfDay());

        query.setParameter(6, openingDate);
        query.setParameter(7, closingDate);
        query.setParameter(8, id);

        return query.executeUpdate(); // 영향 받은 행
    }

    @Transactional
    public Integer deleteById(Integer id) {
        String q = "DELETE FROM board_tb WHERE id = ?";
        Query query = entityManager.createNativeQuery(q);
        query.setParameter(1, id);

        return query.executeUpdate(); // 영향 받은 행
    }


    public int countIsEmployerTrue() {
        String q = """
                SELECT COUNT(*) FROM board_tb b INNER JOIN user_tb u ON b.user_id = u.id WHERE u.is_employer = true;
                """;
        Query query = entityManager.createNativeQuery(q);
        Long count = (Long) query.getSingleResult();

        return count.intValue();
    }
}
