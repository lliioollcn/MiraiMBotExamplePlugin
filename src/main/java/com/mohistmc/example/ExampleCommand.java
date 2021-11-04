package com.mohistmc.example;

import com.mohistmc.miraimbot.annotations.Command;
import com.mohistmc.miraimbot.annotations.NoShow;
import com.mohistmc.miraimbot.annotations.OnlyOp;
import com.mohistmc.miraimbot.annotations.Permission;
import com.mohistmc.miraimbot.command.CommandExecutor;
import com.mohistmc.miraimbot.command.CommandResult;
import com.mohistmc.miraimbot.utils.Msg;
import lombok.extern.slf4j.Slf4j;

@NoShow// 如果有这个注解,这个指令将不会出现在help列表里，但是op发送的#help指令仍然包含
//@NoShow(opCan = false)// 如果有这个注解,这个指令将不会出现在help列表里，包括op
@OnlyOp// 如果有这个注解,说明这个指令只有op可以使用，忽略Permission注解
@Permission("base.base")// 如果有这个注解,这个指令就只有有base.base权限的人才可以使用
@Slf4j
@Command("test")// 注册一个通过#test触发的指令
public class ExampleCommand extends CommandExecutor {
    @Override
    public boolean onCommand(CommandResult commandResult) {
        //TODO:
        ExamplePlugin.INSTANCE.getLogger().info("处理指令: {}", commandResult.getLabel());
        commandResult.sendMessageOrGroup(Msg.create().at(commandResult.getSender().getId()).text(" TEST").build());
        return false;
    }
}
