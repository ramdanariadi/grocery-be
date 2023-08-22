package id.grocery.tunas.download;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import id.grocery.tunas.download.dto.DownloadDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DownloadService {

    private AmazonS3 s3Client;

    @Value("${aws.s3.bucket.name}")
    private Optional<String> bucketName;

    public byte[] download(DownloadDTO request){
        S3Object object = s3Client.getObject(bucketName.orElse(""), request.getFilename());
        S3ObjectInputStream objectContent = object.getObjectContent();
        try {
            return objectContent.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
