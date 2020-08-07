package com.joinky.mode.util;

import com.joinky.mode.base.ChannelSelector;
import com.joinky.mode.handler.AlibabaChannleHandler;
import com.joinky.mode.handler.AmazonChannelHandler;
import com.joinky.mode.handler.SuningChannelHandler;
import lombok.Data;

/**
 * @author Joinky
 * @date 2020-07-31
 * 枚举类处理
 */
public enum ChannelSelectorEnum {

    ALIBABA("ALIBABA", new AlibabaChannleHandler()),

    SUNING("SUNING", new SuningChannelHandler()),

    AMAZON("AMAZON", new AmazonChannelHandler());

    public String name;

    public ChannelSelector channelSelector;

    ChannelSelectorEnum(String name, ChannelSelector channelSelector) {
        this.name = name;
        this.channelSelector = channelSelector;
    }

    public static ChannelSelectorEnum match(String name) {
        ChannelSelectorEnum[] enums = ChannelSelectorEnum.values();
        for (ChannelSelectorEnum value: enums) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public ChannelSelector getChannelSelector() {
        return channelSelector;
    }
}
