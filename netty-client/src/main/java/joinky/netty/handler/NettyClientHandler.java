package joinky.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;

/**
 * @author Joinky
 * @date 2020-07-28
 * @version 1.0.0
 * netty客户端处理类
 */
@Slf4j
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    // 连接建立时调用
    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        log.info("Client active...");
    }

    // 接收到消息时调用
    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object message) throws Exception {
        log.info("客户端收到信息：{}", message.toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
        log.error("客户端处理出现异常：{}", throwable.getMessage());
        channelHandlerContext.close();
    }
}
