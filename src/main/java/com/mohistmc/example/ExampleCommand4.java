package com.mohistmc.example;

import com.mohistmc.miraimbot.annotations.Command;
import com.mohistmc.miraimbot.annotations.OnlyOp;
import com.mohistmc.miraimbot.annotations.Permission;
import com.mohistmc.miraimbot.command.CommandExecutor;
import com.mohistmc.miraimbot.command.CommandResult;

@Permission("base.base")// 有base.base权限的人才可以使用
@Command("test4")
public class ExampleCommand4 extends CommandExecutor {
    @Override
    public boolean onCommand(CommandResult commandResult) {
        ExamplePlugin.INSTANCE.getLogger().info("处理指令: {}", commandResult.getLabel());
        return false;
    }
}
