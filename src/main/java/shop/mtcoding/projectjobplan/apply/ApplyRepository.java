package shop.mtcoding.projectjobplan.apply;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ApplyRepository {
    private final EntityManager entityManager;

    @Transactional
    public int upload(ApplyRequest.UploadDTO requestDTO){
        return 0;
    }
    public List<ApplyResponse.ToEmployerDTO>  findByEmployerId(){
        return null;
    }
    public List<ApplyResponse.ToUserDTO> findByUserId(){
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
