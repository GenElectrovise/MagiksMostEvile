package genelectrovise.magiksmostevile.tileentity.inscription_table;

import genelectrovise.magiksmostevile.core.MagiksMostEvile;
import genelectrovise.magiksmostevile.item.equipment.tabulae.Signa;
import genelectrovise.magiksmostevile.item.equipment.tabulae.Signum;
import genelectrovise.magiksmostevile.registry.orbital.registries.ItemOrbitalRegistry;
import genelectrovise.magiksmostevile.registry.orbital.registries.TileEntityOrbitalRegistry;
import genelectrovise.magiksmostevile.tileentity.ICustomContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;

public class InscriptionTableTileEntity extends TileEntity implements ICustomContainer {

  // IItemHandler
  private ItemStackHandler slot;
  protected final LazyOptional<IItemHandler> slot_handler = LazyOptional.of(() -> slot);
  protected final LazyOptional<IItemHandler> allSlots = LazyOptional.of(() -> new CombinedInvWrapper(slot));

  public InscriptionTableTileEntity() {
    super(TileEntityOrbitalRegistry.TILE_ENTITY_INSCRIPTION_TABLE.get());

    slot = new ItemStackHandler() {
      @Override
      protected void onContentsChanged(int slot) {
        markDirty();
      }
    };
  }

  @Override
  public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction side) {

    // IItemHandler
    if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
      this.markDirty();

      // if the block at myself isn't myself, allow full access (Block Broken)
      if (world != null && world.getBlockState(pos).getBlock() != this.getBlockState().getBlock()) {
        return allSlots.cast();
      }
      if (side == null) {
        return allSlots.cast();
      }
    }

    return super.getCapability(capability, side);
  }

  @Override
  public void remove() {
    slot_handler.invalidate();
    allSlots.invalidate();
    super.remove();
  }

  @Override
  public Container createMenu(int id, PlayerInventory playerInv, PlayerEntity player) {
    String exceptionMessage = "InscriptionTableTileEntity found null allSlots! allSlots.orElseThrow(Exception) found null, so threw. id=" + id + " player=" + player.getName().getString();
    return new InscriptionTableContainer(id, playerInv, allSlots.orElseThrow(() -> new NullPointerException(exceptionMessage)), this);
  }

  @Override
  public void openGUI(ServerPlayerEntity player) {
    NetworkHooks.openGui(player, this, getPos());
  }

  @Override
  public ITextComponent getDisplayName() {
    return new TranslationTextComponent(MagiksMostEvile.MODID + ":container.inscription_table");
  }

  public void recipe(ResourceLocation signumName) {
    Signum signum = Signa.SIGNA.get(signumName);

    slot_handler.ifPresent((itemHandler) -> {
      
      ItemStack stackInSlot = itemHandler.getStackInSlot(0).getStack();
      
      if(stackInSlot.getItem() == ItemOrbitalRegistry.BLANK_SIGNUM.get()) {
        itemHandler.extractItem(0, 64, false);
        itemHandler.insertItem(0, new ItemStack(signum.getItem().get(), 1), false);
      }
    });
    
  }
}

