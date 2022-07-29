package me.HybridPlague.MuseumBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.clip.placeholderapi.PlaceholderAPI;

public class Main extends JavaPlugin implements Listener {

	public static Map<String, ItemStack[]> menus = new HashMap<String, ItemStack[]>();
	Map<String, Long> cooldowns = new HashMap<String, Long>();
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		this.saveDefaultConfig();
		
		if (this.getConfig().contains("data")) {
			this.restoreInvs();
		}
	}

	@Override
	public void onDisable() {
		if (!menus.isEmpty()) {
			this.saveInvs();
		}
	}

	public void saveInvs() {
		for (Map.Entry<String, ItemStack[]> entry : menus.entrySet()) {
			this.getConfig().set("data." + entry.getKey(), entry.getValue());
		}
		this.saveConfig();
	}
	
	public void restoreInvs() {
		this.getConfig().getConfigurationSection("data").getKeys(false).forEach(key -> {
			@SuppressWarnings("unchecked")
			ItemStack[] content = ((List<ItemStack>) this.getConfig().get("data." + key)).toArray(new ItemStack[0]);
			menus.put(key, content);
		});
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("needmuseumbook")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command is only executable by a player.");
				return true;
			}
			Player p = (Player) sender;
			String regions = "%worldguard_region_name%";
			regions = PlaceholderAPI.setPlaceholders(p, regions);
			if (!regions.equalsIgnoreCase("museum")) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lHey! &fThat command is only useable inside of the museum."));
				return true;
			}
			
			if (args.length == 0) {
				Inventory main = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&eMain Menu"));
				if (menus.containsKey("Main")) 
					main.setContents(menus.get("Main"));
				
				p.openInventory(main);
				return true;
			}
			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("a")
						|| args[0].equalsIgnoreCase("b")
						|| args[0].equalsIgnoreCase("c")
						|| args[0].equalsIgnoreCase("d")
						|| args[0].equalsIgnoreCase("e")
						|| args[0].equalsIgnoreCase("f")
						|| args[0].equalsIgnoreCase("g")
						|| args[0].equalsIgnoreCase("h")
						|| args[0].equalsIgnoreCase("i")
						|| args[0].equalsIgnoreCase("j")
						|| args[0].equalsIgnoreCase("k")
						|| args[0].equalsIgnoreCase("l")
						|| args[0].equalsIgnoreCase("m")
						|| args[0].equalsIgnoreCase("n")
						|| args[0].equalsIgnoreCase("o")
						|| args[0].equalsIgnoreCase("p")
						|| args[0].equalsIgnoreCase("q")
						|| args[0].equalsIgnoreCase("r")
						|| args[0].equalsIgnoreCase("s")
						|| args[0].equalsIgnoreCase("t")
						|| args[0].equalsIgnoreCase("u")
						|| args[0].equalsIgnoreCase("v")
						|| args[0].equalsIgnoreCase("w")
						|| args[0].equalsIgnoreCase("x")
						|| args[0].equalsIgnoreCase("y")
						|| args[0].equalsIgnoreCase("z")
						|| args[0].equalsIgnoreCase("_")
						|| args[0].equalsIgnoreCase("0")
						|| args[0].equalsIgnoreCase("1")
						|| args[0].equalsIgnoreCase("2")
						|| args[0].equalsIgnoreCase("3")
						|| args[0].equalsIgnoreCase("4")
						|| args[0].equalsIgnoreCase("5")
						|| args[0].equalsIgnoreCase("6")
						|| args[0].equalsIgnoreCase("7")
						|| args[0].equalsIgnoreCase("8")
						|| args[0].equalsIgnoreCase("9")) {
					Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&e" + args[0].toUpperCase()));
					if (menus.containsKey(args[0].toUpperCase())) 
						inv.setContents(menus.get(args[0].toUpperCase()));
					
					p.openInventory(inv);
					return true;
				}
				
			}	
		}
		return false;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eMain Menu"))) {
			Player p = (Player) e.getWhoClicked();
			e.setCancelled(true);
			
			if (e.getCurrentItem() == null) return;
			if (e.getSlot() == 0) {
				Bukkit.dispatchCommand(p, "needmuseumbook a");
			}
			if (e.getSlot() == 1) {
				Bukkit.dispatchCommand(p, "needmuseumbook b");
			}
			if (e.getSlot() == 2) {
				Bukkit.dispatchCommand(p, "needmuseumbook c");
			}
			if (e.getSlot() == 3) {
				Bukkit.dispatchCommand(p, "needmuseumbook d");
			}
			if (e.getSlot() == 4) {
				Bukkit.dispatchCommand(p, "needmuseumbook e");
			}
			if (e.getSlot() == 5) {
				Bukkit.dispatchCommand(p, "needmuseumbook f");
			}
			if (e.getSlot() == 6) {
				Bukkit.dispatchCommand(p, "needmuseumbook g");
			}
			if (e.getSlot() == 7) {
				Bukkit.dispatchCommand(p, "needmuseumbook h");
			}
			if (e.getSlot() == 8) {
				Bukkit.dispatchCommand(p, "needmuseumbook i");
			}
			if (e.getSlot() == 9) {
				Bukkit.dispatchCommand(p, "needmuseumbook j");
			}
			if (e.getSlot() == 10) {
				Bukkit.dispatchCommand(p, "needmuseumbook k");
			}
			if (e.getSlot() == 11) {
				Bukkit.dispatchCommand(p, "needmuseumbook l");
			}
			if (e.getSlot() == 12) {
				Bukkit.dispatchCommand(p, "needmuseumbook m");
			}
			if (e.getSlot() == 13) {
				Bukkit.dispatchCommand(p, "needmuseumbook n");
			}
			if (e.getSlot() == 14) {
				Bukkit.dispatchCommand(p, "needmuseumbook o");
			}
			if (e.getSlot() == 15) {
				Bukkit.dispatchCommand(p, "needmuseumbook p");
			}
			if (e.getSlot() == 16) {
				Bukkit.dispatchCommand(p, "needmuseumbook q");
			}
			if (e.getSlot() == 17) {
				Bukkit.dispatchCommand(p, "needmuseumbook r");
			}
			if (e.getSlot() == 18) {
				Bukkit.dispatchCommand(p, "needmuseumbook s");
			}
			if (e.getSlot() == 19) {
				Bukkit.dispatchCommand(p, "needmuseumbook t");
			}
			if (e.getSlot() == 20) {
				Bukkit.dispatchCommand(p, "needmuseumbook u");
			}
			if (e.getSlot() == 21) {
				Bukkit.dispatchCommand(p, "needmuseumbook v");
			}
			if (e.getSlot() == 22) {
				Bukkit.dispatchCommand(p, "needmuseumbook w");
			}
			if (e.getSlot() == 23) {
				Bukkit.dispatchCommand(p, "needmuseumbook x");
			}
			if (e.getSlot() == 24) {
				Bukkit.dispatchCommand(p, "needmuseumbook y");
			}
			if (e.getSlot() == 25) {
				Bukkit.dispatchCommand(p, "needmuseumbook z");
			}
			if (e.getSlot() == 26) {
				Bukkit.dispatchCommand(p, "needmuseumbook _");
			}
			if (e.getSlot() == 27) {
				Bukkit.dispatchCommand(p, "needmuseumbook 0");
			}
			if (e.getSlot() == 28) {
				Bukkit.dispatchCommand(p, "needmuseumbook 1");
			}
			if (e.getSlot() == 29) {
				Bukkit.dispatchCommand(p, "needmuseumbook 2");
			}
			if (e.getSlot() == 30) {
				Bukkit.dispatchCommand(p, "needmuseumbook 3");
			}
			if (e.getSlot() == 31) {
				Bukkit.dispatchCommand(p, "needmuseumbook 4");
			}
			if (e.getSlot() == 32) {
				Bukkit.dispatchCommand(p, "needmuseumbook 5");
			}
			if (e.getSlot() == 33) {
				Bukkit.dispatchCommand(p, "needmuseumbook 6");
			}
			if (e.getSlot() == 34) {
				Bukkit.dispatchCommand(p, "needmuseumbook 7");
			}
			if (e.getSlot() == 35) {
				Bukkit.dispatchCommand(p, "needmuseumbook 8");
			}
			if (e.getSlot() == 36) {
				Bukkit.dispatchCommand(p, "needmuseumbook 9");
			}
				
			
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eA"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eB"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eC"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eD"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eE"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eF"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eG"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eH"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eI"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eJ"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eK"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eL"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eM"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eN"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eO"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eP"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eQ"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eR"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eS"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eT"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eU"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eV"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eW"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eX"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eY"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eZ"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e_"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e0"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e1"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e2"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e3"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e4"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e5"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e6"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e7"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e8"))
				|| e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e9"))) {
			Player p = (Player) e.getWhoClicked();
			if (!p.hasPermission("museumgui.edit")) {
				e.setCancelled(true);
				
				if (e.getCurrentItem() == null) return; 
				if (e.getCurrentItem().getItemMeta() == null) return; 
				if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return; 
				
				if (e.getCurrentItem().getType().equals(Material.WRITTEN_BOOK)) {
					
					if (cooldowns.containsKey(p.getName())) {
						if (cooldowns.get(p.getName()) > System.currentTimeMillis()) {
							long timeleft = (cooldowns.get(p.getName()) - System.currentTimeMillis()) / 1000;
							p.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "» " + ChatColor.WHITE + "This command has a cooldown. Please wait " + ChatColor.YELLOW + "" + timeleft + ChatColor.WHITE + " more seconds.");
							return;
						}
					}
					cooldowns.put(p.getName(), System.currentTimeMillis() + (120 * 1000));
					
					for (Player op : Bukkit.getOnlinePlayers()) {
						String groups = "%vault_ranks%";
						groups = PlaceholderAPI.setPlaceholders(op, groups);
						if (op.hasPermission("businesscraft.seniortourguide") || groups.contains("CommunityCoordinator") || groups.contains("SeniorTourGuide") || groups.contains("JusticeMinister") || groups.contains("DeputyPrimeMinister") || groups.contains("PrimeMinister") || groups.contains("President")) {
							op.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&m-------------------------------------------------"));
							op.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4** &6&l" + p.getName() + " &bis requesting a book at the Museum! &4**"));
							op.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4** &aMenu &e" + e.getView().getTitle() + "&a, Slot &e" + (e.getSlot() + 1) + " &4**"));
							op.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&m-------------------------------------------------"));
						}
						
					}
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "dopa &e" + p.getName() + " &bis requesting assistance at the Museum!");
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aAlerted all online &bSenior Tour Guides &aand &bCommunity Coordinators&a! Press Tab and see if anyone has the &bSTG &aor &bCC &atag. If not, no STGs or CCs are online."));
				}
				
			}
		}
	}
	
	
	@EventHandler
	public void onGUIClose(InventoryCloseEvent e) {
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eMain Menu"))) {
			menus.put("Main", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eA"))) {
			menus.put("A", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eB"))) {
			menus.put("B", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eC"))) {
			menus.put("C", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eD"))) {
			menus.put("D", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eE"))) {
			menus.put("E", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eF"))) {
			menus.put("F", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eG"))) {
			menus.put("G", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eH"))) {
			menus.put("H", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eI"))) {
			menus.put("I", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eJ"))) {
			menus.put("J", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eK"))) {
			menus.put("K", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eL"))) {
			menus.put("L", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eM"))) {
			menus.put("M", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eN"))) {
			menus.put("N", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eO"))) {
			menus.put("O", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eP"))) {
			menus.put("P", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eQ"))) {
			menus.put("Q", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eR"))) {
			menus.put("R", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eS"))) {
			menus.put("S", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eT"))) {
			menus.put("T", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eU"))) {
			menus.put("U", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eV"))) {
			menus.put("V", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eW"))) {
			menus.put("W", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eX"))) {
			menus.put("X", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eY"))) {
			menus.put("Y", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&eZ"))) {
			menus.put("Z", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e_"))) {
			menus.put("_", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e0"))) {
			menus.put("0", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e1"))) {
			menus.put("1", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e2"))) {
			menus.put("2", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e3"))) {
			menus.put("3", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e4"))) {
			menus.put("4", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e5"))) {
			menus.put("5", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e6"))) {
			menus.put("6", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e7"))) {
			menus.put("7", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e8"))) {
			menus.put("8", e.getInventory().getContents());
		}
		if (e.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', "&e9"))) {
			menus.put("9", e.getInventory().getContents());
		}
	}
	
	
}
