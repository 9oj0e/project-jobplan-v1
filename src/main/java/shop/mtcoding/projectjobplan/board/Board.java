package shop.mtcoding.projectjobplan.board;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "board_tb")
public class Board {
    @Id
    private int id;
}
