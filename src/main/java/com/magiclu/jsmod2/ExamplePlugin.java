package com.magiclu.jsmod2;


import cn.jsmod2.api.map.IMap;
import cn.jsmod2.core.GameServer;
import cn.jsmod2.core.annotations.EnableRegister;
import cn.jsmod2.core.annotations.Main;
import cn.jsmod2.core.interapi.IServer;
import cn.jsmod2.core.plugin.PluginBase;

@Main(
        name="ExamplePlugin",
        description = "Example Plugin",
        version = "1.1.0"
)//标记是一个主类，必须继承PluginBase
@EnableRegister //开启自动注册
//主类
public class ExamplePlugin extends PluginBase {

    private static PluginBase main;

    @Override
    public void onLoad() {
        this.getLogger().info("Welcome to ExamplePlugin,Hello,Jsmod2");


    }

    @Override
    public void onEnable() {
        main = this;
        this.getLogger().info("插件加载成功");
        //get Server
        IServer server = this.getServer();
        GameServer gameServer = server.getGameServer();
        IMap map = gameServer.getMap();//获取map
        map.clearBroadcasts();//调用api，清理公告
    }

    @Override
    public void onDisable() {
        this.getLogger().info("插件关闭");
    }

    public static PluginBase getMain() {
        return main;
    }
}
