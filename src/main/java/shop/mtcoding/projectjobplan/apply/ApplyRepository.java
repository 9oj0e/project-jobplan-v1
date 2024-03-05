package shop.mtcoding.projectjobplan.apply;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
public class ApplyRepository {
    private final EntityManager entityManager;

    @Transactional
    public int upload(ApplyRequest.UploadDTO requestDTO){
        return 0;
    }
    public ApplyResponse.ToEmployerDTO findByEmployerId(){
        return null;
    }
    public ApplyResponse.ToUserDTO findByUserId(){
        return null;
    }
    @Transactional
    public int update(ApplyRequest.UpdateDTO requestDTO){
        return 0;
    }
    @Transactional
    public int deleteByEmployerId(){
        return 0;
    }
    @Transactional
    public int deleteByUserId(){
        return 0;
    }
}
