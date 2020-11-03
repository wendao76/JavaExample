package com.github.wendao76.markdown;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className TestMain
 * @date 2020-11-3 9:23
 */
public class TestMain {
  public static void main(String[] args) throws IOException {
    String templateContent = "This is a ```姓名：${user.name}， 年龄：${user.age}``` template";
    User user = new User();
    user.setName("aaaaaa");
    user.setAge(100);


    StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
    Configuration cfg = Configuration.defaultConfiguration();
    GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
    //获取模板
    Template t = gt.getTemplate((Object)templateContent);
    t.binding("user", user);
    //渲染结果
    templateContent = t.render();
    MutableDataSet options = new MutableDataSet();
    // uncomment to set optional extensions
    //options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(), StrikethroughExtension.create()));

    // uncomment to convert soft-breaks to hard breaks
    //options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");

    Parser parser = Parser.builder(options).build();
    HtmlRenderer renderer = HtmlRenderer.builder(options).build();

    // You can re-use parser and renderer instances
    Node document = parser.parse(templateContent);
    String html = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
    System.out.println(html);
  }

  @Data
  static class User{
    private String name;
    private Integer age;
  }
}
