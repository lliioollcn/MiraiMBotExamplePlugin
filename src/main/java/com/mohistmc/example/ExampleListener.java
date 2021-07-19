package com.mohistmc.example;

import com.mohistmc.miraimbot.annotations.Listener;
import com.google.common.eventbus.Subscribe;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.MessageEvent;

@Listener
public class ExampleListener extends SimpleListenerHost {

    @Subscribe
    public void onMessage(MessageEvent event) {
        ExamplePlugin.INSTANCE.getLogger().info("收到消息: {}", event.getMessage());
    }
}
