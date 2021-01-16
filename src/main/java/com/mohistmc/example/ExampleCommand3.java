package com.mohistmc.example;

import com.mohistmc.miraimbot.annotations.Command;
import com.mohistmc.miraimbot.annotations.OnlyOp;
import com.mohistmc.miraimbot.command.CommandExecutor;
import com.mohistmc.miraimbot.command.CommandResult;

@OnlyOp// 只有op可以使用，忽略权限
@Command("test3")
public class ExampleCommand3 extends CommandExecutor {
    @Override
    public boolean onCommand(CommandResult commandResult) {
        ExamplePlugin.INSTANCE.getLogger().info("处理指令: {}", commandResult.getLabel());
        return false;
    }
}
