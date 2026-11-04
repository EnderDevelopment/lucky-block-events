package com.enderdevelopment.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("LuckyBlockEvents has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("LuckyBlockEvents has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("luckyblock")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                ItemStack luckyBlock = new ItemStack(Material.SPONGE);
                ItemMeta meta = luckyBlock.getItemMeta();
                meta.displayName(Component.text("Lucky Block").color(NamedTextColor.GOLD));
                luckyBlock.setItemMeta(meta);
                player.getInventory().addItem(luckyBlock);
                player.sendMessage(Component.text("You have received a Lucky Block!").color(NamedTextColor.GREEN));
                return true;
            } else {
                sender.sendMessage(Component.text("Only players can use this command!").color(NamedTextColor.RED));
                return false;
            }
        }
        return false;
    }
}