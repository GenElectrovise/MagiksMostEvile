/**
 * 
 */
package genelectrovise.magiksmostevile.common.entity.boss.kitty_the_kraken;

import javax.annotation.Nullable;
import genelectrovise.magiksmostevile.common.core.SetupManager;
import genelectrovise.magiksmostevile.common.entity.boss.BossMob;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.World;

/**
 * @author GenElectrovise 23 Jun 2020
 */
public class KittyTheKrakenEntity extends BossMob {

  private boolean squidMissileAttacking = false;
  private final KrakenArm leftArm = new KrakenArm(this, KrakenArm.KrakenArmSide.LEFT);
  private final KrakenArm rightArm = new KrakenArm(this, KrakenArm.KrakenArmSide.RIGHT);

  /**
   * @param type
   * @param worldIn
   */
  public KittyTheKrakenEntity(EntityType<? extends KittyTheKrakenEntity> type, World worldIn) {
    super(type, worldIn);
  }

  /**
   * Static! Non-inherited! Create a map of attributes. Called from {@link SetupManager}.
   */
  public static AttributeModifierMap.MutableAttribute getEntityAttributes() {
    return MobEntity.func_233666_p_() //
        .createMutableAttribute(Attributes.MAX_HEALTH, 100.0D)
        .createMutableAttribute(Attributes.FLYING_SPEED, 2.0f)
        .createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0f)
        .createMutableAttribute(Attributes.ATTACK_SPEED, 5.0f)
        .createMutableAttribute(Attributes.FOLLOW_RANGE, 64.0f);
  }

  @Override
  public double getPosYEye() {
    return this.getPosY() + 4.5;
  }

  /**
   * @return {@link #leftArm}, otherwise {@link #rightArm}. If {@link #rightArm} is not usable, null.
   */
  @Nullable
  public KrakenArm getFirstUsableArm() {
    return leftArm.isUsable() ? leftArm : (rightArm.isUsable() ? rightArm : null);
  }

  // Get and set

  public boolean isSquidMissileAttacking() {
    return squidMissileAttacking;
  }

  public void setSquidMissileAttacking(boolean squidMissileAttacking) {
    this.squidMissileAttacking = squidMissileAttacking;
  }

  public KrakenArm getLeftArm() {
    return leftArm;
  }

  public KrakenArm getRightArm() {
    return rightArm;
  }

}