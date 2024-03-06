package shop.mtcoding.projectjobplan.pic;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import shop.mtcoding.projectjobplan.user.User;
import shop.mtcoding.projectjobplan.user.UserRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class PicController {
    private final UserRepository userRepository;
    private final PicRepository picRepository;

    private final String uploadDir = "./upload/";

    @GetMapping("/upload/{filename:.+}")
    public void serveFile(@PathVariable String filename, HttpServletResponse response) {
        Path file = Paths.get(uploadDir, filename);
        try (FileInputStream fis = new FileInputStream(file.toFile());
             OutputStream os = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int b;
            while ((b = fis.read(buffer)) != -1) {
                os.write(buffer, 0, b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @PostMapping("/upload/{id}")
    public String upload(PicRequest.UploadDTO requestDTO, @PathVariable int id, HttpServletRequest request){
        // 1. 데이터 전달 받고
        String title = requestDTO.getTitle();
        MultipartFile imgFile = requestDTO.getImgFile();

        // 2. 파일저장 위치 설정해서 파일을 저장 (UUID 붙여서 롤링)
        String imgFilename = UUID.randomUUID()+"_"+imgFile.getOriginalFilename();
        Path imgPath = Paths.get("./upload/"+imgFilename);
        try {
            Files.write(imgPath, imgFile.getBytes());

            // 3. DB에 저장 (title, realFileName)
            picRepository.insert(id, imgFilename);

            Pic pic = picRepository.findById(1);
            request.getSession().setAttribute("pic", pic);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/user/"+id;
    }

    @GetMapping("/uploadForm/{id}")
    public String uploadForm(@PathVariable int id, HttpServletRequest request){
        User user = userRepository.findById(id);
        request.setAttribute("user", user);
        return "user/uploadForm";
    }

    @PostMapping("/deleteImg")
    public String deleteImg(@RequestParam int userId, HttpServletRequest request) {
        picRepository.deleteByUserId(userId);

        request.getSession().removeAttribute("pic");

        return "redirect:/user/"+userId;
    }

}