package shop.mtcoding.projectjobplan.pic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
public class PicRepository {
    private final EntityManager em;

    @Transactional
    public void insert(String title, String imgFilename){
        Query query = em.createNativeQuery("insert into pic_tb (img_filename) values (?)");
        query.setParameter(1, imgFilename);

        query.executeUpdate();
    }

    @Transactional
    public Pic findById(int id){
        Query query = em.createNativeQuery("select * from pic_tb where id = ?", Pic.class);
        query.setParameter(1, id);

        return (Pic) query.getSingleResult();
    }
}