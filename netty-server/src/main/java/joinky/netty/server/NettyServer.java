package joinky.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import joinky.netty.util.ServerInitializer;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

/**
 * 定义netty服务端
 * 提供端口绑定和相关编解码
 * @author Joinky
 * @version 1.0.0
 * @date 2020-07-28
 */
@Slf4j
public class NettyServer {

    public void bindServer(InetSocketAddress address) {
        // 创建boss线程池
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 创建worker线程池
        EventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap server = new ServerBootstrap();
        server.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
                .localAddress(address)
                .childHandler(new ServerInitializer())
                // 设置队列大小
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true);
        try {
            ChannelFuture future = server.bind(address).sync();
            log.info("服务端监听端口：{}", address.getPort());
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("Create netty server error: {}", e.getMessage());
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
