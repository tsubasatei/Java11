package com.xt.java.java11;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamTest {

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
