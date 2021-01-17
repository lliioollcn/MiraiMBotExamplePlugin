# MiraiMBotExamplePlugin

> 这是 [MiraiMBot](https://github.com/Mohist-Community/MiraiMBot) 的插件模板
>
> 强烈建议您在看完 [mirai的开发文档](https://github.com/mamoe/mirai/blob/dev/docs/README.md) 之后再来看这个文档
>
> 首先:
> * 您需要有一定的的java开发能力
> * 您需要会使用gradle
> * 您需要会使用IDEA
> * 您需要会使用 [mirai](https://github.com/mamoe/mirai) 进行开发
> * 如果你有什么问题，可以 [加入QQ群](https://qm.qq.com/cgi-bin/qm/qr?k=ZXJuf2VSDk5tzZe5DkZXUcdkkawCDxqv&jump_from=webapi) 进行交流

## 开始
> 1. 将这个仓库clone下来
> 2. 导入IDEA
> 3. 然后开始开发

MiraiMBot插件通过注解来声明自己，他就像[这样](https://github.com/lliioollcn/MiraiMBotExamplePlugin/blob/main/src/main/java/com/mohistmc/example/ExamplePlugin.java): 
> 无需单独写plugin.yml文件,在构建时他会自己生成
```java
import com.mohistmc.miraimbot.annotations.Plugin;
import com.mohistmc.miraimbot.plugin.MohistPlugin;

@Plugin(value = "插件名称", version = "插件版本", authors = {"插件作者"}, description = "插件简介")
public class ExamplePlugin extends MohistPlugin {

    public static ExamplePlugin INSTANCE;

    @Override
    public void onLoad() {
        INSTANCE = this;
        getLogger().info("启动中...");
    }

    @Override
    public void onEnable() {
        getLogger().info("启动完毕");
    }

    @Override
    public void onDisable() {
        getLogger().info("卸载完毕");
    }
}
```
如果你开启了自带的指令系统,你也可以通过 [这样](https://github.com/lliioollcn/MiraiMBotExamplePlugin/blob/main/src/main/java/com/mohistmc/example/ExamplePlugin.java) 来声明一个指令处理器:
> 无需手动注册,MiraiMBot会自动帮你注册
```java
import com.mohistmc.miraimbot.annotations.Command;
import com.mohistmc.miraimbot.annotations.NoShow;
import com.mohistmc.miraimbot.annotations.OnlyOp;
import com.mohistmc.miraimbot.annotations.Permission;
import com.mohistmc.miraimbot.command.CommandExecutor;
import com.mohistmc.miraimbot.command.CommandResult;

@NoShow// 如果有这个注解,这个指令将不会出现在help列表里，但是op发送的#help指令仍然包含
//@NoShow(opCan = false)// 如果有这个注解,这个指令将不会出现在help列表里，包括op
@OnlyOp// 如果有这个注解,说明这个指令只有op可以使用，忽略Permission注解
@Permission("base.base")// 如果有这个注解,这个指令就只有有base.base权限的人才可以使用
@Command("test")// 注册一个通过#test触发的指令
public class ExampleCommand extends CommandExecutor {
    @Override
    public boolean onCommand(CommandResult commandResult) {
        //TODO: 
        ExamplePlugin.INSTANCE.getLogger().info("处理指令: {}", commandResult.getLabel());
        return false;
    }
}
```
如果你想要监听mirai的一个事件,你可以 [这样](https://github.com/lliioollcn/MiraiMBotExamplePlugin/blob/main/src/main/java/com/mohistmc/example/ExampleListener.java) 监听:
> 同指令一样,MiraiMBot也会帮你自动注册
```java
import com.mohistmc.miraimbot.annotations.Listener;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.MessageEvent;

@Listener
public class ExampleListener extends SimpleListenerHost {

    @EventHandler
    public void onMessage(MessageEvent event) {
        ExamplePlugin.INSTANCE.getLogger().info("收到消息: {}", event.getMessage());
    }
}
```
至此,你可以进行MiraiMBot插件的开发了.

## 构建
要构建MiraiMBot插件,就如同其他的gradle项目一样,直接build即可.
<br>
但有一点要注意的是,你要在 ***build/distributions*** 寻找构建好的jar而不是 build/libs

## 运行
运行请看 [MiraiMBot](https://github.com/Mohist-Community/MiraiMBot) 的运行