package shop.mtcoding.projectjobplan.pic;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/upload")
public class PicFileController {

    @GetMapping("/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename) throws IOException {
        // 해당 경로의 이미지를 읽어와서 바이트 배열로 변환
        Path imagePath = Paths.get("./upload/" + filename);
        byte[] imageBytes = Files.readAllBytes(imagePath);

        // HTTP 응답에 이미지 바이트 배열과 적절한 헤더를 설정하여 반환
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // 이미지 타입에 맞게 수정
                .body(imageBytes);
    }
}
