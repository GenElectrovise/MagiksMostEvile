package genelectrovise.magiksmostevile.common.network.particle.ender;

import genelectrovise.magiksmostevile.common.main.MagiksMostEvile;
import net.minecraft.network.PacketBuffer;

/**
 * @author GenElectrovise 24 May 2020
 */
public class EnderParticleMessageToServer {

	protected EnderParticleMessageToServer() {
		
	}

	public void encode(PacketBuffer buffer) {
		MagiksMostEvile.LOGGER.dev("Encoding message to server");
	}

	public static EnderParticleMessageToServer decode(PacketBuffer buffer) {
		MagiksMostEvile.LOGGER.dev("Decoding message to server");
		return new EnderParticleMessageToServer();
	}

	public boolean isValid() {
		return false;
	}
}
