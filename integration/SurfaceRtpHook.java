package com.example.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Copy-paste helper for plugin developers: send players on a SurfaceRTP random teleport
 * from your own plugin.
 * <p>
 * SurfaceRTP needs no API dependency - the helper runs its console command, which skips
 * the cooldown and the countdown and uses all the safe-landing checks.
 * Add {@code softdepend: [SurfaceRTP]} to your plugin.yml so SurfaceRTP loads first.
 *
 * <pre>{@code
 * if (SurfaceRtpHook.isAvailable()) {
 *     SurfaceRtpHook.teleport(player);
 * }
 * }</pre>
 */
public final class SurfaceRtpHook {

    private SurfaceRtpHook() {
    }

    /** Whether SurfaceRTP is installed and enabled on this server. */
    public static boolean isAvailable() {
        return Bukkit.getPluginManager().isPluginEnabled("SurfaceRTP");
    }

    /** Random teleport in the player's current world. Returns false if SurfaceRTP is missing. */
    public static boolean teleport(Player player) {
        return run("surfacertp:rtp player " + player.getName());
    }

    /** Random teleport in the given world. Returns false if SurfaceRTP is missing. */
    public static boolean teleport(Player player, String worldName) {
        return run("surfacertp:rtp player " + player.getName() + " " + worldName);
    }

    private static boolean run(String command) {
        return isAvailable() && Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
    }
}
