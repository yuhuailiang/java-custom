package joinky.netty;

import joinky.netty.client.NettyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
public class NettyClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyClientApplication.class, args);
        NettyClient client = new NettyClient();
        client.connect2Server(new InetSocketAddress("127.0.0.1", 8090));
    }
}
