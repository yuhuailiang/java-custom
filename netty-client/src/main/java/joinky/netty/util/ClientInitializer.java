package joinky.netty.util;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import joinky.netty.handler.NettyClientHandler;

/**
 * @author Joinky
 * @date 2020-07-28
 * @version 1.0.0
 * 客户端初始化处理
 */
public class ClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast("decoder", new StringDecoder());
        socketChannel.pipeline().addLast("encoder", new StringEncoder());
        socketChannel.pipeline().addLast(new NettyClientHandler());
    }
}
