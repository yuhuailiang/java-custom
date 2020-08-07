package joinky.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import joinky.netty.handler.NettyClientHandler;
import joinky.netty.util.ClientInitializer;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

/**
 * @author Joinky
 * @date 2020-07-28
 * @version 1.0.0
 * netty客户端连接类
 */
@Slf4j
public class NettyClient {

    public void connect2Server(InetSocketAddress address) {
        EventLoopGroup loopGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(loopGroup)
                .option(ChannelOption.TCP_NODELAY, true)
                .channel(NioSocketChannel.class)
                .handler(new ClientInitializer());
        try {
            ChannelFuture future = bootstrap.connect("127.0.0.1", 8090).sync();
            log.info("连接成功...");
            future.channel().writeAndFlush("你好！");
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("初始化连接异常：{}", e.getMessage());
        } finally {
            loopGroup.shutdownGracefully();
        }
    }
}
