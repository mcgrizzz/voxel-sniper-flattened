package com.thevoxelbox.voxelsniper.brush.performer.type.ink;

import com.thevoxelbox.voxelsniper.brush.performer.type.AbstractPerformer;
import com.thevoxelbox.voxelsniper.sniper.toolkit.Messages;
import com.thevoxelbox.voxelsniper.sniper.toolkit.ToolkitProperties;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

public class InkPerformer extends AbstractPerformer {

	private BlockData blockData;

	public InkPerformer() {
		super("Ink");
	}

	@Override
	public void init(ToolkitProperties toolkitProperties) {
		this.world = toolkitProperties.getWorld();
		this.blockData = toolkitProperties.getBlockData();
	}

	@Override
	public void info(Messages messages) {
		messages.performerName(this.getName());
		messages.blockData();
	}

	@Override
	public void perform(Block block) {
		this.undo.put(block);
		block.setBlockData(this.blockData);
	}
}