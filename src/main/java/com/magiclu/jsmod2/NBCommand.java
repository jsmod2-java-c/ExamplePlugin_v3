package com.magiclu.jsmod2;

import cn.jsmod2.api.player.Player;
import cn.jsmod2.core.CommandSender;
import cn.jsmod2.core.command.Command;
import cn.jsmod2.core.log.ServerLogger;
import cn.jsmod2.core.plugin.Plugin;

public class NBCommand extends Command {

    public NBCommand(Plugin plugin) {
        super("nb", "hello world", plugin);
    }

    @Override
    public boolean execute(CommandSender commandSender, String[] strings) {
        ServerLogger.getLogger().info("执行成功NB_COMMAND");
        return false;
    }
}
