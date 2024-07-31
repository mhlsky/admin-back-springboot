package com.mhlsky.admin;

import com.mhlsky.common.exception.ApiException;
import com.mhlsky.common.exception.error.ErrorCode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.mhlsky.*"})
public class BackAdminApplication {

    public static void main(String[] args)   {

        var application = SpringApplication.run(BackAdminApplication.class, args);

        String successMsg =
                "            ||       ||          ||               \n" +
                ".. .. ..    || ..    ||   ....   ||  ..  .... ... \n" +
                " || || ||   ||' ||   ||  ||. '   || .'    '|.  |  \n" +
                " || || ||   ||  ||   ||  . '|..  ||'|.     '|.|   \n" +
                ".|| || ||. .||. ||. .||. |'..|' .||. ||.    '|    \n" +
                "                                         .. |     \n" +
                "                                          ''      ";
        System.out.println(successMsg);
        Environment env = application.getEnvironment();

        // 获取ip
        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new ApiException(ErrorCode.Internal.STARTER_INTERNET_ERROR);
        }
        String port = env.getProperty("server.port");
        String property = env.getProperty("server.servlet.context-path");
        String path = property == null ? "" :  property;
        System.out.println(
                "\n\t" +
                        "----------------------------------------------------------\n\t" +
                        "Application  is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                        "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                        "------------------------------------------------------------");


    }

}
