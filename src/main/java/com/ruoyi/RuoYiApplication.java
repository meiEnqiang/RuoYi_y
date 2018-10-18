package com.ruoyi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.ruoyi.project.*.*.mapper")
@EnableCaching
public class RuoYiApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println(ansi().eraseScreen().render("@|green (♥◠‿◠)ﾉﾞ  若依启动成功   ლ(´ڡ`ლ)ﾞ  \n|@" +
                "@|red  .-------.       ____     __        \n|@" +
                "@|green  |  _ _   \\      \\   \\   /  /    \n|@" +
                "@|yellow  | ( ' )  |       \\  _. /  '       \n|@" +
                "@|red  |(_ o _) /        _( )_ .'         \n|@" +
                "@|green  | (_,_).' __  ___(_ o _)'          \n|@" +
                "@|yellow  |  |\\ \\  |  ||   |(_,_)'         \n|@" +
                "@|red  |  | \\ `'   /|   `-'  /           \n|@" +
                "@|green  |  |  \\    /  \\      /           \n|@" +
                "@|yellow  ''-'   `'-'    `-..-'              |@"));

        System.out.println( ansi().eraseScreen().render("@|red Mei |@" +  "@|green En |@" + "@|yellow Qiang |@") );
    }
}