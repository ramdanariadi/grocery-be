package id.grocery.tunas.export;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExportRequestService {

    private AmazonS3 s3Client;

    @Value("${aws.s3.bucket.name}")
    private Optional<String> s3Bucket;

    private final Logger LOGGER = LoggerFactory.getLogger(ExportRequestService.class);

    public void testUpload(){
        String filename = UUID.randomUUID() + ".xls";
        String[] header = new String[]{"FO"};
        String[][] content = new String[][]{
                new String[]{"bar1"},
                new String[]{"bar1"}
        };
        String sheetName = "Sheet1";
        try(ByteArrayOutputStream out = new ByteArrayOutputStream()){
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet(Strings.isNullOrEmpty(sheetName) ? "Sheet1" : sheetName);
            Row row = sheet.createRow(0);
            for (int i = 0; i < header.length; i++) {
                row.createCell(i).setCellValue(header[i]);
            }

            for (int i = 0; i < content.length; i++) {
                Row row1 = sheet.createRow(i + 1);
                for (int i1 = content[i].length - 1; i1 >= 0; i1--) {
                    row1.createCell(i1).setCellValue(content[i][i1]);
                }
            }
            workbook.write(out);
            try{
                byte[] byteArray = out.toByteArray();
                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentType("application/x-excel");
                objectMetadata.setContentLength(byteArray.length);
                PutObjectRequest putObjectRequest = new PutObjectRequest(
                        s3Bucket.orElse(""), filename, new ByteArrayInputStream(byteArray), objectMetadata);
                s3Client.putObject(putObjectRequest);
            }catch (Exception e){
                LOGGER.info("putObjectException : {}", e.getMessage());
            }

        }catch (Exception e){
            LOGGER.error("creating-workbook-file-error: {}",e.getMessage());
        }
    }
}
