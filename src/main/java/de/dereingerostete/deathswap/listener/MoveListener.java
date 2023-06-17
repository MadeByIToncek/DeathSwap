package de.dereingerostete.deathswap.listener;

import de.dereingerostete.deathswap.DeathSwapPlugin;
import de.dereingerostete.deathswap.util.GameState;
import de.dereingerostete.deathswap.util.Permissions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.jetbrains.annotations.NotNull;

public class MoveListener implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void onMove(@NotNull PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (player.hasPermission(Permissions.MOD_PERMISSION)) return;

		GameState state = DeathSwapPlugin.getOptions().getState();
		if (state == GameState.WAITING_FOR_PLAYERS ||
				state == GameState.STARTING ||
				DeathSwapPlugin.getOptions().isTeleportingDelayActive()) {
			event.setCancelled(true);
		}
	}

}
