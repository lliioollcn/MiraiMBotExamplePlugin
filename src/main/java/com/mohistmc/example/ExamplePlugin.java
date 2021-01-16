package com.mohistmc.example;

import com.mohistmc.miraimbot.annotations.Plugin;
import com.mohistmc.miraimbot.plugin.MohistPlugin;

@Plugin(value = "ExamplePlugin", version = "0.0.1", authors = {"lliiooll"}, description = "一个示例插件")
public class ExamplePlugin extends MohistPlugin {

    public static ExamplePlugin INSTANCE;

    @Override
    public void onLoad() {
        INSTANCE = this;
        getLogger().info("启动中...");
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("启动完毕");
    }

    @Override
    public void onDisable() {
        getLogger().info("卸载完毕");
    }
}
