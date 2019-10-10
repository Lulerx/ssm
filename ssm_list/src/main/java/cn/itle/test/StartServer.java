package cn.itle.test;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

//逆向生成映射文件
public class StartServer {

    public void generator() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("src\\main\\resources\\genarator.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) throws Exception {
        try {
            StartServer startServer = new StartServer();
            startServer.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//        <dependency>
//      <groupId>org.mybatis.generator</groupId>
//      <artifactId>mybatis-generator-core</artifactId>
//      <version>1.3.2</version>
//    </dependency>

}
