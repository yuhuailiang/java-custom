package com.joinky.mode;

import com.joinky.mode.base.ChannelSelector;
import com.joinky.mode.util.ChannelSelectorEnum;

/**
 * @author Joinky
 * @date 2020-07-31
 * 枚举类型代替if-else
 * 测试类
 */
public class EnumModeDemo {

    public static void main(String[] args) {
        String ali = "ALIBABA";
        ChannelSelectorEnum selectorEnum = ChannelSelectorEnum.match(ali);
        ChannelSelector selector = selectorEnum.channelSelector;
        selector.hanler();
    }
}
