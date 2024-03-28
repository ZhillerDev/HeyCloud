package io.zhiller.fo.utils.base;


import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhiller
 * 读取文件工具类
 */
public class FileIOUtils {
  /*测试文件IO读写的方法*/
  public static void main(String[] args) {

  }

  public static String readPdf(InputStream inputStream) {
    PDDocument pdDocument = null;
    String content = "";
    try {
      //创建解析器对象
      PDFParser pdfParser = new PDFParser(new RandomAccessReadBuffer(inputStream));
      pdDocument = pdfParser.parse();
      //pdf文档
//            pdDocument = pdfParser.getPDDocument();
      //pdf文本操作对象,使用该对象可以获取所读取pdf的一些信息
      PDFTextStripper pdfTextStripper = new PDFTextStripper();
      content = pdfTextStripper.getText(pdDocument);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      IOUtils.closeQuietly(inputStream);
      IOUtils.closeQuietly(pdDocument);
    }
    return content;
  }

  private static String readTxt(InputStream inputStream, String extendName) throws IOException {
    try {
      byte[] bytes = IOUtils.toByteArray(inputStream);
      byte[] result = CharsetUtils.convertTxtCharsetToUTF8(bytes, extendName);
      return IOUtils.toString(result, "UTF-8");
    } finally {
      IOUtils.closeQuietly(inputStream);
    }
  }
}
