/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thevoxelbox.voxelsniper.brush.perform;

import com.thevoxelbox.voxelsniper.Message;
import org.bukkit.block.Block;

/**
 * @author Voxel
 */
public class ComboMatPerformer extends AbstractPerformer {

	private byte d;
	private int i;
	private int ir;

	public ComboMatPerformer() {
		this.setName("Combo-Mat");
	}

	@Override
	public void init(com.thevoxelbox.voxelsniper.SnipeData snipeData) {
		this.world = snipeData.getWorld();
		this.d = snipeData.getData();
		this.i = snipeData.getVoxelId();
		this.ir = snipeData.getReplaceId();
	}

	@Override
	public void info(Message message) {
		message.performerName(this.getName());
		message.voxel();
		message.replace();
		message.data();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void perform(Block block) {
		if (block.getTypeId() == this.ir) {
			this.undo.put(block);
			block.setTypeIdAndData(this.i, this.d, true);
		}
	}

	@Override
	public boolean isUsingReplaceMaterial() {
		return true;
	}
}