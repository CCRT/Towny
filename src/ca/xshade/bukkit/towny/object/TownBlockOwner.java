package ca.xshade.bukkit.towny.object;

import java.util.ArrayList;
import java.util.List;

import ca.xshade.bukkit.towny.AlreadyRegisteredException;
import ca.xshade.bukkit.towny.NotRegisteredException;

public class TownBlockOwner extends TownyIConomyObject {
	protected List<TownBlock> townBlocks = new ArrayList<TownBlock>();
	protected TownyPermission permissions = new TownyPermission();

	public void setTownblocks(List<TownBlock> townblocks) {
		this.townBlocks = townblocks;
	}

	public List<TownBlock> getTownBlocks() {
		return townBlocks;
	}

	public boolean hasTownBlock(TownBlock townBlock) {
		return townBlocks.contains(townBlock);
	}

	public void addTownBlock(TownBlock townBlock) throws AlreadyRegisteredException {
		if (hasTownBlock(townBlock))
			throw new AlreadyRegisteredException();
		else
			townBlocks.add(townBlock);
	}

	public void removeTownBlock(TownBlock townBlock) throws NotRegisteredException {
		if (!hasTownBlock(townBlock))
			throw new NotRegisteredException();
		else
			townBlocks.remove(townBlock);
	}

	public void setPermissions(String line) {
		permissions.reset();
		permissions.load(line);
	}

	public TownyPermission getPermissions() {
		return permissions;
	}
}
