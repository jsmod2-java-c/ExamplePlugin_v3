package com.magiclu.jsmod2;

import cn.jsmod2.api.event.player.IPlayerJoinEvent;
import cn.jsmod2.api.event.player.IPlayerPickupItemEvent;
import cn.jsmod2.core.annotations.EventManager;
import cn.jsmod2.core.event.Listener;
import cn.jsmod2.core.plugin.PluginBase;

/**
 * 一个简易的关于玩家加入服务器的案例
 *
 */
public class PlayerListener implements Listener {

    public PlayerListener(){
        System.out.println("加载了这个监听器");
    }

    //如果启用自动注册，监听器是在onEnable后注册的
    private PluginBase main = ExamplePlugin.getMain();


    @EventManager
    public void onPlayerJoin(IPlayerJoinEvent e){
        main.getLogger().info("监听到了玩家进入");
        int id = e.getPlayer().getPlayerId();
        String name = e.getPlayer().getName();
        e.getPlayer().personalBroadcast(0,"欢迎"+name+"加入服务器::id:"+id,false);
    }

    @EventManager
    public void onPlayerPickupItem(IPlayerPickupItemEvent e){
        e.getItem().remove();
        main.debug("删除了玩家手中的物品");
    }

}
