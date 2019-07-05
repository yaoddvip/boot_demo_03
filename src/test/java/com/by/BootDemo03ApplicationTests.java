package com.by;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootDemo03ApplicationTests {

    @Autowired
    private Configuration configuration;

    @Test
    public void contextLoads() {
        String w = "Welcome FreeMarker!";
        try {
            Template template = configuration.getTemplate("test.ftl");
            Map<String,Object> map = new HashMap<>();
            map.put("w",w);
            // 指定文件输出路径以及文件名
            Writer out = new FileWriter(new File("E:/test.html"));
            // 输出文件
            template.process(map, out);
            // 关闭流
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

}
