package io.zhiller.heycloud.operator;

import io.zhiller.fo.operator.upload.factory.LocalUploader;
import io.zhiller.fo.operator.upload.factory.MinioUploader;
import io.zhiller.fo.operator.upload.model.UploadFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UploadTest {

  @Autowired
  private LocalUploader localUploader;
  @Autowired
  private MinioUploader minioUploader;

  @Test
  public void uploadImageLocal() {

  }

  @Test
  public void uploadImageMinio() {

  }
}
