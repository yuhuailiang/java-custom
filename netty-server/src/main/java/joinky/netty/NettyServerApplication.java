package joinky.netty;

import joinky.netty.server.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

/**
 * @author Joinky
 * @date 2020-07-28
 * @version 1.0.0
 * netty-server启动类
 */
@SpringBootApplication
public class NettyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyServerApplication.class, args);
        NettyServer server = new NettyServer();
        // 绑定端口为本地8090
        server.bindServer(new InetSocketAddress("127.0.0.1", 8090));
    }
}
