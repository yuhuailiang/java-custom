package joinky.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joinky
 * @date 2020-07-28
 * @version 1.0.0
 * 服务端处理类
 */
@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 客户端连接时调用
     * @param channelHandlerContext
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        log.info("Channel active...");
    }

    /**
     * 客户端发消息时调用
     * @param channelHandlerContext
     * @param message
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object message) throws Exception {
        log.info("服务端收到消息：{}", message.toString());
        channelHandlerContext.write("我给你回复了哈");
        channelHandlerContext.flush();
    }

    /**
     * 出现异常时调用
     * @param channelHandlerContext
     * @param throwable
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
        log.error("处理时出现异常：{}", throwable.getMessage());
        // 异常时关闭
        channelHandlerContext.close();
    }
}
