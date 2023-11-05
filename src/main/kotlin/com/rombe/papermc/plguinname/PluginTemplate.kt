package com.rombe.papermc.plguinname

import org.bukkit.plugin.java.JavaPlugin

class PluginTemplate : JavaPlugin() {
    override fun onEnable() = logger.info("Plugin template enabled")

    override fun onDisable() = logger.info("Plugin template disabled")
}