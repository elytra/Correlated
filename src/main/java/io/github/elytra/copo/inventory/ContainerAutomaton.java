package io.github.elytra.copo.inventory;

import io.github.elytra.copo.entity.EntityAutomaton;
import io.github.elytra.copo.entity.EntityAutomaton.AutomatonStatus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.IInventory;

public class ContainerAutomaton extends ContainerVT {
	public EntityAutomaton automaton;
	public EntityPlayer player;
	
	public ContainerAutomaton(IInventory playerInventory, EntityPlayer player, EntityAutomaton automaton) {
		super(playerInventory, player, automaton);
		this.automaton = automaton;
		this.player = player;
		addSlotToContainer(new SlotEquipment(automaton, EntityEquipmentSlot.MAINHAND, 116, 21));
		addSlotToContainer(new SlotEquipment(automaton, EntityEquipmentSlot.OFFHAND, 134, 21));
		addSlotToContainer(new SlotEquipment(automaton, EntityEquipmentSlot.HEAD, 152, 21));
	}
	

	@Override
	protected void initializeVTSize() {
		startX = 8;
		startY = 44;
		slotsAcross = 8;
		slotsTall = 4;
		hasCraftingMatrix = false;
		playerInventoryOffsetX = 0;
		playerInventoryOffsetY = -7;
	}
	
	@Override
	public boolean enchantItem(EntityPlayer playerIn, int id) {
		switch (id) {
			case -30:
				automaton.setStatus(AutomatonStatus.WANDER);
				break;
			case -31:
				automaton.setStatus(AutomatonStatus.ATTACK);
				break;
			case -32:
				automaton.setStatus(AutomatonStatus.FOLLOW);
				break;
			case -33:
				automaton.setStatus(AutomatonStatus.STAY);
				break;
			case -34:
				automaton.setStatus(AutomatonStatus.EXEC);
				break;

			case -59:
				automaton.setFollowDistance((automaton.getFollowDistance()+1)%4);
				break;
			case -60:
				automaton.setMuted(!automaton.isMuted());
				break;
			default:
				return super.enchantItem(playerIn, id);
		}
		return true;
	}

}
