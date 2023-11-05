package com.rombe.papermc.plguinname

import org.bukkit.plugin.java.JavaPlugin

class PluginTemplate : JavaPlugin() {
    override fun onEnable() = logger.info("Plugin template enabled ${listOf(1, 2, 3).find { it == 5 } ?: -1}")

    override fun onDisable() = logger.info("Plugin template disabled")
}