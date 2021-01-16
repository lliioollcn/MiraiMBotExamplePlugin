package com.mohistmc.example;

import com.mohistmc.miraimbot.annotations.Command;
import com.mohistmc.miraimbot.annotations.NoShow;
import com.mohistmc.miraimbot.command.CommandExecutor;
import com.mohistmc.miraimbot.command.CommandResult;

@NoShow// 他将不会出现在help列表里，但是op发送的#help指令仍然包含
@Command("test1")
public class ExampleCommand1 extends CommandExecutor {
    @Override
    public boolean onCommand(CommandResult commandResult) {
        ExamplePlugin.INSTANCE.getLogger().info("处理指令: {}", commandResult.getLabel());
        return false;
    }
}
