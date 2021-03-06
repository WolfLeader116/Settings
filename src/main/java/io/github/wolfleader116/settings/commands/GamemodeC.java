package io.github.wolfleader116.settings.commands;

import io.github.wolfleader116.settings.Config;
import io.github.wolfleader116.settings.Settings;
import io.github.wolfleader116.wolfapi.Errors;
import io.github.wolfleader116.wolfapi.WolfAPI;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeC implements CommandExecutor {
	private static final Logger log = Logger.getLogger("Minecraft");

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Config c = new Config("playerdata", Settings.plugin);
		if (cmd.getName().equalsIgnoreCase("gamemode")) {
			if (!(sender instanceof Player)) {
				if (args.length == 0) {
					log.info("Please enter a gamemode and player.");
				} else if (args.length >= 1) {
					if (args.length == 1) {
						log.info("Please enter a player.");
					} else if (args.length >= 2) {
						if (Bukkit.getServer().getPlayer(args[1]) == null) {
							log.info("The specified player is not online!");
						} else {
							Player player = Bukkit.getServer().getPlayer(args[1]);
							if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")) {
								player.setGameMode(GameMode.SURVIVAL);
								WolfAPI.message("Your game mode has been set to survival by the console", player, "Settings");
								log.info(args[1] + "'s game mode has been set to survival");
								if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(true);
									if (!(player.isOnGround())) {
										player.setFlying(true);
									}
								} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(false);
								}
							} else if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")) {
								player.setGameMode(GameMode.CREATIVE);
								WolfAPI.message("Your game mode has been set to creative by the console", player, "Settings");
								log.info(args[1] + "'s game mode has been set to creative");
								if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(true);
									if (!(player.isOnGround())) {
										player.setFlying(true);
									}
								} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(false);
								}
							} else if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")) {
								player.setGameMode(GameMode.ADVENTURE);
								WolfAPI.message("Your game mode has been set to adventure by the console", player, "Settings");
								log.info(args[1] + "'s game mode has been set to adventure");
								if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(true);
									if (!(player.isOnGround())) {
										player.setFlying(true);
									}
								} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(false);
								}
							} else if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("r")) {
								player.setGameMode(GameMode.SPECTATOR);
								WolfAPI.message("Your game mode has been set to spectator by the console", player, "Settings");
								log.info(args[1] + "'s game mode has been set to spectator");
								if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(true);
									if (!(player.isOnGround())) {
										player.setFlying(true);
									}
								} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(false);
								}
							} else {
								log.info("Possible gamemodes are survival/creative/adventure/spectator, 0/1/2/3 or s/c/a/r.");
							}
						}
					}
				}
			} else if ((sender instanceof Player)) {
				Player p = (Player) sender;
				if (sender.hasPermission("settings.gamemode")) {
					if (args.length == 0) {
						Errors.sendError(Errors.CUSTOM, p, "Settings", "Please enter a gamemode!");
					} else if (args.length >= 1) {
						if (args.length == 1) {
							Player player1 = (Player) sender;
							if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")) {
								player1.setGameMode(GameMode.SURVIVAL);
								WolfAPI.message("Your game mode has been set to survival", p, "Settings");
								if (c.getConfig().getBoolean("fly." + player1.getUniqueId())) {
									player1.setAllowFlight(true);
									if (!(player1.isOnGround())) {
										player1.setFlying(true);
									}
								} else if (!c.getConfig().getBoolean("fly." + player1.getUniqueId())) {
									player1.setAllowFlight(false);
								}
							} else if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")) {
								player1.setGameMode(GameMode.CREATIVE);
								WolfAPI.message("Your game mode has been set to creative", p, "Settings");
								if (c.getConfig().getBoolean("fly." + player1.getUniqueId())) {
									player1.setAllowFlight(true);
									if (!(player1.isOnGround())) {
										player1.setFlying(true);
									}
								} else if (!c.getConfig().getBoolean("fly." + player1.getUniqueId())) {
									player1.setAllowFlight(false);
								}
							} else if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")) {
								player1.setGameMode(GameMode.ADVENTURE);
								WolfAPI.message("Your game mode has been set to adventure", p, "Settings");
								if (c.getConfig().getBoolean("fly." + player1.getUniqueId())) {
									player1.setAllowFlight(true);
									if (!(player1.isOnGround())) {
										player1.setFlying(true);
									}
								} else if (!c.getConfig().getBoolean("fly." + player1.getUniqueId())) {
									player1.setAllowFlight(false);
								}
							} else if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("r")) {
								player1.setGameMode(GameMode.SPECTATOR);
								WolfAPI.message("Your game mode has been set to spectator", p, "Settings");
								if (c.getConfig().getBoolean("fly." + player1.getUniqueId())) {
									player1.setAllowFlight(true);
									if (!(player1.isOnGround())) {
										player1.setFlying(true);
									}
								} else if (!c.getConfig().getBoolean("fly." + player1.getUniqueId())) {
									player1.setAllowFlight(false);
								}
							}
						} else if (args.length >= 2) {
							if (Bukkit.getServer().getPlayer(args[1]) == null) {
								Errors.sendError(Errors.NOT_ONLINE, p, "Settings");
							} else {
								Player player2 = Bukkit.getServer().getPlayer(args[1]);
								Player send = (Player) sender;
								if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")) {
									player2.setGameMode(GameMode.SURVIVAL);
									WolfAPI.message("Your game mode has been set to survival by " + ChatColor.RESET + send.getName().toString(), p, "Settings");
									WolfAPI.message(ChatColor.RESET + args[0] + ChatColor.GREEN + "'s game mode has been set to survival", p, "Settings");
									if (c.getConfig().getBoolean("fly." + player2.getUniqueId())) {
										player2.setAllowFlight(true);
										if (!(player2.isOnGround())) {
											player2.setFlying(true);
										}
									} else if (!c.getConfig().getBoolean("fly." + player2.getUniqueId())) {
										player2.setAllowFlight(false);
									}
								} else if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")) {
									player2.setGameMode(GameMode.CREATIVE);
									WolfAPI.message("Your game mode has been set to creative by " + ChatColor.RESET + send.getName().toString(), p, "Settings");
									WolfAPI.message(ChatColor.RESET + args[0] + ChatColor.GREEN + "'s game mode has been set to creative", p, "Settings");
									if (c.getConfig().getBoolean("fly." + player2.getUniqueId())) {
										player2.setAllowFlight(true);
										if (!(player2.isOnGround())) {
											player2.setFlying(true);
										}
									} else if (!c.getConfig().getBoolean("fly." + player2.getUniqueId())) {
										player2.setAllowFlight(false);
									}
								} else if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")) {
									player2.setGameMode(GameMode.ADVENTURE);
									WolfAPI.message("Your game mode has been set to adventure by " + ChatColor.RESET + send.getName().toString(), p, "Settings");
									WolfAPI.message(ChatColor.RESET + args[0] + ChatColor.GREEN + "'s game mode has been set to adventure", p, "Settings");
									if (c.getConfig().getBoolean("fly." + player2.getUniqueId())) {
										player2.setAllowFlight(true);
										if (!(player2.isOnGround())) {
											player2.setFlying(true);
										}
									} else if (!c.getConfig().getBoolean("fly." + player2.getUniqueId())) {
										player2.setAllowFlight(false);
									}
								} else if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("r")) {
									player2.setGameMode(GameMode.SPECTATOR);
									WolfAPI.message("Your game mode has been set to spectator by " + ChatColor.RESET + send.getName().toString(), p, "Settings");
									WolfAPI.message(ChatColor.RESET + args[0] + ChatColor.GREEN + "'s game mode has been set to spectator", p, "Settings");
									if (c.getConfig().getBoolean("fly." + player2.getUniqueId())) {
										player2.setAllowFlight(true);
										if (!(player2.isOnGround())) {
											player2.setFlying(true);
										}
									} else if (!c.getConfig().getBoolean("fly." + player2.getUniqueId())) {
										player2.setAllowFlight(false);
									}
								} else {
									Errors.sendError(Errors.CUSTOM, p, "Settings", "Possible gamemodes are survival/creative/adventure/spectator, 0/1/2/3 or s/c/a/r.");
								}
							}
						}
					}
				} else {
					Errors.sendError(Errors.NO_PERMISSION, p, "Settings");
				}
			}
		} else if (cmd.getName().equalsIgnoreCase("survival") || cmd.getName().equalsIgnoreCase("creative") || cmd.getName().equalsIgnoreCase("adventure") || cmd.getName().equalsIgnoreCase("spectator")) {
			if (!(sender instanceof Player)) {
				if (args.length == 0) {
					log.info("Please enter a player.");
				} else if (args.length >= 1) {
					Player player = Bukkit.getServer().getPlayer(args[0]);
					if (Bukkit.getServer().getPlayer(args[0]) == null) {
						log.info("The specified player is not online!");
					} else if (cmd.getName().equalsIgnoreCase("survival")) {
						player.setGameMode(GameMode.SURVIVAL);
						WolfAPI.message("Your game mode has been set to survival by the console", player, "Settings");
						log.info(args[0] + "'s game mode has been set to survival");
						if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
							player.setAllowFlight(true);
							if (!(player.isOnGround())) {
								player.setFlying(true);
							}
						} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
							player.setAllowFlight(false);
						}
					} else if (cmd.getName().equalsIgnoreCase("creative")) {
						player.setGameMode(GameMode.CREATIVE);
						WolfAPI.message("Your game mode has been set to creative by the console", player, "Settings");
						log.info(args[0] + "'s game mode has been set to creative");
						if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
							player.setAllowFlight(true);
							if (!(player.isOnGround())) {
								player.setFlying(true);
							}
						} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
							player.setAllowFlight(false);
						}
					} else if (cmd.getName().equalsIgnoreCase("adventure")) {
						player.setGameMode(GameMode.ADVENTURE);
						WolfAPI.message("Your game mode has been set to adventure by the console", player, "Settings");
						log.info(args[0] + "'s game mode has been set to adventure");
						if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
							player.setAllowFlight(true);
							if (!(player.isOnGround())) {
								player.setFlying(true);
							}
						} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
							player.setAllowFlight(false);
						}
					} else if (cmd.getName().equalsIgnoreCase("spectator")) {
						player.setGameMode(GameMode.SPECTATOR);
						WolfAPI.message("Your game mode has been set to spectator by the console", player, "Settings");
						log.info(args[0] + "'s game mode has been set to spectator");
						if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
							player.setAllowFlight(true);
							if (!(player.isOnGround())) {
								player.setFlying(true);
							}
						} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
							player.setAllowFlight(false);
						}
					}
				}
			} else if (sender instanceof Player) {
				Player p = (Player) sender;
				if (args.length == 0) {
					if (sender.hasPermission("settings.gamemode")) {
						Player player = (Player) sender;
						if (cmd.getName().equalsIgnoreCase("survival")) {
							player.setGameMode(GameMode.SURVIVAL);
							WolfAPI.message("Your game mode has been set to survival", p, "Settings");
							if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
								player.setAllowFlight(true);
								if (!(player.isOnGround())) {
									player.setFlying(true);
								}
							} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
								player.setAllowFlight(false);
							}
						} else if (cmd.getName().equalsIgnoreCase("creative")) {
							player.setGameMode(GameMode.CREATIVE);
							WolfAPI.message("Your game mode has been set to creative", p, "Settings");
							if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
								player.setAllowFlight(true);
								if (!(player.isOnGround())) {
									player.setFlying(true);
								}
							} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
								player.setAllowFlight(false);
							}
						} else if (cmd.getName().equalsIgnoreCase("adventure")) {
							player.setGameMode(GameMode.ADVENTURE);
							WolfAPI.message("Your game mode has been set to adventure", p, "Settings");
							if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
								player.setAllowFlight(true);
								if (!(player.isOnGround())) {
									player.setFlying(true);
								}
							} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
								player.setAllowFlight(false);
							}
						} else if (cmd.getName().equalsIgnoreCase("spectator")) {
							player.setGameMode(GameMode.SPECTATOR);
							WolfAPI.message("Your game mode has been set to spectator", p, "Settings");
							if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
								player.setAllowFlight(true);
								if (!(player.isOnGround())) {
									player.setFlying(true);
								}
							} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
								player.setAllowFlight(false);
							}
						}
					} else {
						Errors.sendError(Errors.NO_PERMISSION, p, "Settings");
					}
				} else if (args.length >= 1) {
					if (sender.hasPermission("settings.gamemode.other")) {
						Player player = Bukkit.getServer().getPlayer(args[0]);
						Player send = (Player) sender;
						if (player == null) {
							Errors.sendError(Errors.NOT_ONLINE, p, "Settings");
						} else {
							if (cmd.getName().equalsIgnoreCase("survival")) {
								player.setGameMode(GameMode.SURVIVAL);
								WolfAPI.message("Your game mode has been set to survival by " + ChatColor.RESET + send.getName().toString(), p, "Settings");
								WolfAPI.message(ChatColor.RESET + args[0] + ChatColor.GREEN + "'s game mode has been set to survival", p, "Settings");
								if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(true);
									if (!(player.isOnGround())) {
										player.setFlying(true);
									}
								} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(false);
								}
							} else if (cmd.getName().equalsIgnoreCase("creative")) {
								player.setGameMode(GameMode.CREATIVE);
								WolfAPI.message("Your game mode has been set to creative by " + ChatColor.RESET + send.getName().toString(), p, "Settings");
								WolfAPI.message(ChatColor.RESET + args[0] + ChatColor.GREEN + "'s game mode has been set to creative", p, "Settings");
								if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(true);
									if (!(player.isOnGround())) {
										player.setFlying(true);
									}
								} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(false);
								}
							} else if (cmd.getName().equalsIgnoreCase("adventure")) {
								player.setGameMode(GameMode.ADVENTURE);
								WolfAPI.message("Your game mode has been set to adventure by " + ChatColor.RESET + send.getName().toString(), p, "Settings");
								WolfAPI.message(ChatColor.RESET + args[0] + ChatColor.GREEN + "'s game mode has been set to adventure", p, "Settings");
								if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(true);
									if (!(player.isOnGround())) {
										player.setFlying(true);
									}
								} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(false);
								}
							} else if (cmd.getName().equalsIgnoreCase("spectator")) {
								player.setGameMode(GameMode.SPECTATOR);
								WolfAPI.message("Your game mode has been set to spectator by " + ChatColor.RESET + send.getName().toString(), p, "Settings");
								WolfAPI.message(ChatColor.RESET + args[0] + ChatColor.GREEN + "'s game mode has been set to spectator", p, "Settings");
								if (c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(true);
									if (!(player.isOnGround())) {
										player.setFlying(true);
									}
								} else if (!c.getConfig().getBoolean("fly." + player.getUniqueId())) {
									player.setAllowFlight(false);
								}
							}
						}
					} else {
						Errors.sendError(Errors.NO_PERMISSION, p, "Settings");
					}
				}
			}
		}
		return false;
	}
}
