package com.xt.java11;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xt
 * @create 2019/3/25 9:19
 * @Desc
 */
public class InputStreanTest {

    @Test
    public void test() throws IOException {
        var cl = this.getClass().getClassLoader();
        var fis = cl.getResourceAsStream("file");
        try(var fos = new FileOutputStream("file2")){
            // 把输入流中的所有数据直接自动的复制到输出流中
            fis.transferTo(fos);
        }
        fis.close();
    }
}
