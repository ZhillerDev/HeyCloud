package io.zhiller.fo.utils.base;


import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

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

  /**
   * 根据文件类型返回文件内容
   *
   * @param fileType    文件类型
   * @param inputStream 输入流
   * @return 结果
   * @throws IOException io异常
   */
  public static String getContentByInputStream(String fileType, InputStream inputStream) throws IOException {
    if ("doc".equals(fileType) || "docx".equals(fileType)) {
      return readWord(inputStream, fileType);
    } else if ("txt".equals(fileType)) {
      return readTxt(inputStream, fileType);
    } else if ("pdf".equals(fileType)) {
      return readPdf(inputStream);
    } else {
      System.out.println("不支持的文件类型！");
    }
    return "";
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

  /**
   * 读取word
   *
   * @param fileType    文件类型
   * @param inputStream 输入流
   * @return 结果
   */
  public static String readWord(InputStream inputStream, String fileType) {
    String buffer = "";
    try {
      if ("doc".equalsIgnoreCase(fileType)) {
        WordExtractor ex = new WordExtractor(inputStream);
        buffer = ex.getText();
        ex.close();
      } else if ("docx".equalsIgnoreCase(fileType)) {
        XWPFWordExtractor extractor = new XWPFWordExtractor(OPCPackage.open(inputStream));
        buffer = extractor.getText();
        extractor.close();

      } else {
        System.out.println("此文件不是word文件！");
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      IOUtils.closeQuietly(inputStream);
    }

    return buffer;
  }
}
