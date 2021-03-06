package genelectrovise.magiksmostevile.common.network.altar.cast_button;

import genelectrovise.magiksmostevile.common.main.MagiksMostEvile;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;

/**
 * @author GenElectrovise 24 May 2020
 */
public class AltarCastButtonPressedMessageToServer {

	private static boolean messageIsValid;

	private ResourceLocation ritualResourceLocation;

	public AltarCastButtonPressedMessageToServer(ResourceLocation ritualResourceLocation) {
		messageIsValid = true;

		this.ritualResourceLocation = ritualResourceLocation;
	}

	public void encode(PacketBuffer buffer) {
		MagiksMostEvile.LOGGER.dev("Encoding AltarCastButtonPressedMessageToServer.");

		buffer.writeResourceLocation(ritualResourceLocation);
	}

	public static AltarCastButtonPressedMessageToServer decode(PacketBuffer buffer) {
		MagiksMostEvile.LOGGER.dev("Decoding AltarCastButtonPressedMessageToServer");

		ResourceLocation ritualResourceLocation = buffer.readResourceLocation();

		return new AltarCastButtonPressedMessageToServer(ritualResourceLocation);
	}

	public boolean isValid() {
		return messageIsValid;
	}

	/**
	 * @return the ritualName
	 */
	public ResourceLocation getRitualResourceLocation() {
		return ritualResourceLocation;
	}
}
