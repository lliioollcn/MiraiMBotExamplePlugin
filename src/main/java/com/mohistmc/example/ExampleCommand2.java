package com.mohistmc.example;

import com.mohistmc.miraimbot.annotations.Command;
import com.mohistmc.miraimbot.annotations.NoShow;
import com.mohistmc.miraimbot.command.CommandExecutor;
import com.mohistmc.miraimbot.command.CommandResult;

@NoShow(opCan = false)// 他将不会出现在help列表里，包括op
@Command("test2")
public class ExampleCommand2 extends CommandExecutor {
    @Override
    public boolean onCommand(CommandResult commandResult) {
        ExamplePlugin.INSTANCE.getLogger().info("处理指令: {}", commandResult.getLabel());
        return false;
    }
}
