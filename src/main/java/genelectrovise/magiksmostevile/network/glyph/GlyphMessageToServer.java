package genelectrovise.magiksmostevile.network.glyph;

import genelectrovise.magiksmostevile.core.MagiksMostEvile;
import net.minecraft.network.PacketBuffer;

/**
 * @author GenElectrovise 24 May 2020
 */
public class GlyphMessageToServer {

  protected GlyphMessageToServer() {

  }

  public void encode(PacketBuffer buffer) {
    MagiksMostEvile.LOGGER.debug("Encoding message to server");
  }

  public static GlyphMessageToServer decode(PacketBuffer buffer) {
    MagiksMostEvile.LOGGER.debug("Decoding message to server");
    return new GlyphMessageToServer();
  }

  public boolean isValid() {
    return false;
  }
}