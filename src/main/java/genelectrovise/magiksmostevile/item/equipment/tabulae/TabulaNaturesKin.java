package genelectrovise.magiksmostevile.item.equipment.tabulae;

import java.util.List;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.world.World;

public class TabulaNaturesKin extends Tabula {

  public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
    ItemStack stack = player.getHeldItem(hand);

    // Only operate on the server
    if (world.isRemote) {
      return ActionResult.resultPass(stack);
    }

    return ActionResult.resultSuccess(stack);
  }

  @Override
  public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
    tooltip.add(TextComponentUtils.toTextComponent(() -> "You feel at peace with the world around you..."));
    super.addInformation(stack, worldIn, tooltip, flagIn);
  }
}