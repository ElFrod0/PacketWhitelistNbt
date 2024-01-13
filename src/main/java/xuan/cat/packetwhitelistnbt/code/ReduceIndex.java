package xuan.cat.packetwhitelistnbt.code;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import xuan.cat.packetwhitelistnbt.api.branch.BranchMinecraft;
import xuan.cat.packetwhitelistnbt.api.branch.BranchNBT;
import xuan.cat.packetwhitelistnbt.api.branch.BranchPacket;
import xuan.cat.packetwhitelistnbt.code.branch.v14.Branch_14_Minecraft;
import xuan.cat.packetwhitelistnbt.code.branch.v14.Branch_14_NBT;
import xuan.cat.packetwhitelistnbt.code.branch.v14.Branch_14_Packet;
import xuan.cat.packetwhitelistnbt.code.branch.v15.Branch_15_Minecraft;
import xuan.cat.packetwhitelistnbt.code.branch.v15.Branch_15_NBT;
import xuan.cat.packetwhitelistnbt.code.branch.v15.Branch_15_Packet;
import xuan.cat.packetwhitelistnbt.code.branch.v16.Branch_16_Minecraft;
import xuan.cat.packetwhitelistnbt.code.branch.v16.Branch_16_NBT;
import xuan.cat.packetwhitelistnbt.code.branch.v16.Branch_16_Packet;
import xuan.cat.packetwhitelistnbt.code.branch.v17.Branch_17_Minecraft;
import xuan.cat.packetwhitelistnbt.code.branch.v17.Branch_17_NBT;
import xuan.cat.packetwhitelistnbt.code.branch.v17.Branch_17_Packet;
import xuan.cat.packetwhitelistnbt.code.branch.v18.Branch_18_Minecraft;
import xuan.cat.packetwhitelistnbt.code.branch.v18.Branch_18_NBT;
import xuan.cat.packetwhitelistnbt.code.branch.v18.Branch_18_Packet;
import xuan.cat.packetwhitelistnbt.code.branch.v19.Branch_19_Minecraft;
import xuan.cat.packetwhitelistnbt.code.branch.v19.Branch_19_NBT;
import xuan.cat.packetwhitelistnbt.code.branch.v19.Branch_19_Packet;
import xuan.cat.packetwhitelistnbt.code.branch.v20.Branch_20_Minecraft;
import xuan.cat.packetwhitelistnbt.code.branch.v20.Branch_20_NBT;
import xuan.cat.packetwhitelistnbt.code.branch.v20.Branch_20_Packet;
import xuan.cat.packetwhitelistnbt.code.command.Command;
import xuan.cat.packetwhitelistnbt.code.command.CommandSuggest;
import xuan.cat.packetwhitelistnbt.code.data.ConfigData;

public final class ReduceIndex extends JavaPlugin {
    private static Plugin plugin;
    private static ReduceServer reduceServer;
    private static ConfigData configData;
    private static BranchNBT branchNBT;
    private static BranchPacket branchPacket;
    private static BranchMinecraft branchMinecraft;

    public void onEnable() {
        plugin = this;

        saveDefaultConfig();

        // 檢測版本
        String bukkitVersion = Bukkit.getBukkitVersion();
        if (bukkitVersion.matches("^1\\.14\\D.*$")) {
            // 1.14
            branchPacket    = new Branch_14_Packet();
            branchNBT       = new Branch_14_NBT();
            branchMinecraft = new Branch_14_Minecraft();
        } else if (bukkitVersion.matches("^1\\.15\\D.*$")) {
            // 1.15
            branchPacket    = new Branch_15_Packet();
            branchNBT       = new Branch_15_NBT();
            branchMinecraft = new Branch_15_Minecraft();
        } else if (bukkitVersion.matches("^1\\.16\\D.*$")) {
            // 1.16
            branchPacket    = new Branch_16_Packet();
            branchNBT       = new Branch_16_NBT();
            branchMinecraft = new Branch_16_Minecraft();
        } else if (bukkitVersion.matches("^1\\.17\\D.*$")) {
            // 1.17
            branchPacket    = new Branch_17_Packet();
            branchNBT       = new Branch_17_NBT();
            branchMinecraft = new Branch_17_Minecraft();
        } else if (bukkitVersion.matches("^1\\.18\\D.*$")) {
            // 1.18
            branchPacket    = new Branch_18_Packet();
            branchNBT       = new Branch_18_NBT();
            branchMinecraft = new Branch_18_Minecraft();
        } else if (bukkitVersion.matches("^1\\.19\\D.*$")) {
            // 1.19
            branchPacket    = new Branch_19_Packet();
            branchNBT       = new Branch_19_NBT();
            branchMinecraft = new Branch_19_Minecraft();
        } else if (bukkitVersion.matches("^1\\.20\\D.*$")) {
            // 1.19
            branchPacket    = new Branch_20_Packet();
            branchNBT       = new Branch_20_NBT();
            branchMinecraft = new Branch_20_Minecraft();
        } else {
            throw new IllegalArgumentException("Unsupported MC version: " + bukkitVersion);
        }

        configData = new ConfigData(this, getConfig(), branchNBT);
        reduceServer = new ReduceServer(configData, this);

        Bukkit.getPluginManager().registerEvents(new ReduceEvent(configData, reduceServer, branchPacket, branchMinecraft), this);

        // 指令
        PluginCommand command = getCommand("whitelistnbt");
        if (command != null) {
            command.setExecutor(new Command(reduceServer, configData));
            command.setTabCompleter(new CommandSuggest());
        }
    }

    public static ReduceServer getReduceServer() {
        return reduceServer;
    }

    public static ConfigData getConfigData() {
        return configData;
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public void onDisable() {
        if (reduceServer != null) {
            reduceServer.close();
        }
    }
}
