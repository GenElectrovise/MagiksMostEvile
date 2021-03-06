/**
 * 
 */
package genelectrovise.magiksmostevile.common.entity.goal;

import java.util.Random;

import genelectrovise.magiksmostevile.common.entity.vampire_bat.VampireBatEntity;
import genelectrovise.magiksmostevile.common.main.MagiksMostEvile;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

/**
 * Functionality moved to {@link VampireBatBiteGoal} for concurrency.
 * 
 * @author GenElectrovise 6 Jun 2020
 */
@Deprecated
public class VampireBatSummonAidGoal extends Goal {

	private VampireBatEntity vampireBat;
	private int cooldownMax;
	private int cooldown;
	private int maxReinforcements;

	/**
	 * @param vampireBatEntity
	 */
	public VampireBatSummonAidGoal(VampireBatEntity vampireBatEntity, int cooldownMax, int maxReinforcements) {
		this.vampireBat = vampireBatEntity;
		this.cooldownMax = cooldownMax;
		this.cooldown = cooldownMax;
		this.maxReinforcements = maxReinforcements;
	}

	@Override
	public boolean shouldExecute() {
		vampireBat.isInActiveLightLevel();
		if (this.vampireBat.isInActiveLightLevel() && this.vampireBat.getAttackTarget() != null && this.vampireBat.getAttackTarget().isAlive()) {
			return true;
		}

		return false;
	}

	@Override
	public void startExecuting() {

		MagiksMostEvile.LOGGER.dev("Flappys!");

		if (this.cooldown > 3) {
			if (vampireBat.getRNG().nextBoolean()) {
				cooldown = cooldownMax;
			}
			return;
		}

		if (vampireBat.world instanceof ServerWorld) {// && vampireBat.getRNG().nextInt(10) == 0) {
			ServerWorld world = (ServerWorld) vampireBat.world;

			for (int i = 0; i < maxReinforcements + 1; i++) {
				Random rand = vampireBat.getRNG();

				if (rand.nextBoolean()) {
					double x = vampireBat.getPosX();
					double y = vampireBat.getPosY();
					double z = vampireBat.getPosZ();

					double nearbyX = x + nearbyPos(rand, 5);
					double nearbyY = y + nearbyPos(rand, 5);
					double nearbyZ = z + nearbyPos(rand, 5);

					if (world.getBlockState(new BlockPos(nearbyX, nearbyY, nearbyZ)).getBlock() == Blocks.AIR) {
						vampireBat.getType().create(world).setLocationAndAngles(nearbyX, nearbyY, nearbyZ, vampireBat.rotationYaw, vampireBat.rotationPitch);
					}
				}
			}
		}

		cooldown--;

		super.startExecuting();
	}

	private double nearbyPos(Random rand, int radius) {
		return rand.nextInt(radius * 2) - radius + 0.5d;
	}

}
