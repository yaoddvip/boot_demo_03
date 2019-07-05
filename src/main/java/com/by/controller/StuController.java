package com.by.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("stu")
public class StuController {

    @Autowired
    private Configuration configuration;

    @RequestMapping("test1")
    public String test1(Model model){

        String w = "Welcome FreeMarker!";

        try {
            //指定模板
            Template template = configuration.getTemplate("test.ftl");
            // 创建一个数据集
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
        model.addAttribute("w",w);
        return "test";
    }



}
