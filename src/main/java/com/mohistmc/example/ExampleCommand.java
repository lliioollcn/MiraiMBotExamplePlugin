package com.mohistmc.example;

import com.mohistmc.miraimbot.annotations.Command;
import com.mohistmc.miraimbot.command.CommandExecutor;
import com.mohistmc.miraimbot.command.CommandResult;

@Command("test")
public class ExampleCommand extends CommandExecutor {


    @Override
    public boolean onCommand(CommandResult commandResult) {
        ExamplePlugin.INSTANCE.getLogger().info("处理指令: {}", commandResult.getLabel());
        return false;
    }
}
