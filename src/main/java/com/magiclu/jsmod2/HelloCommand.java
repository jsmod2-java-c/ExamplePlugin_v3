package com.magiclu.jsmod2;


import cn.jsmod2.api.player.IPlayer;
import cn.jsmod2.core.CommandSender;
import cn.jsmod2.core.command.Command;
import cn.jsmod2.core.plugin.Plugin;

//一个简单的指令实例
public class HelloCommand extends Command {


    public HelloCommand(Plugin plugin) {
        super("hello", "hello world", plugin);
    }

    @Override
    public boolean execute(CommandSender commandSender, String[] strings) {
        if(commandSender instanceof IPlayer){
            IPlayer player = (IPlayer) commandSender;
            player.personalBroadcast(0,"hello,world",false);
            return true;
        }
        ExamplePlugin.getMain().getLogger().info("执行命令成功");
        return false;
    }
}
