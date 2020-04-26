package com.finalworrior.utils.file;/**
 * Created by yixuan11 on 2020/4/26.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * create by yixuan11 2020-04-26 14:51.
 **/
public class FileUtils {
  private static final Logger LOG = LoggerFactory.getLogger(FileUtils.class);


  /**
   * @param filePath 文件完全限定名。
   * @return 文件内容组成的字符串。
   */
  public static String readFile(String filePath) throws Exception {
    LOG.info("read file from " + filePath);
    StringBuilder sql = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(
            Objects.requireNonNull(FileUtils.class.getClassLoader()
                .getResourceAsStream(filePath)),
            StandardCharsets.UTF_8))) {
      String line;
      while ((line = reader.readLine()) != null) {
        sql.append(line);
        sql.append("\n");
      }
    }
    return sql.toString();
  }
}
