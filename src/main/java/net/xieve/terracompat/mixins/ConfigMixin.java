package net.xieve.terracompat.mixins;

import com.dfsek.terra.config.pack.ConfigPackTemplate;
import net.xieve.terracompat.ConfigInterface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ConfigPackTemplate.class)
public abstract class ConfigMixin implements ConfigInterface {
	@Shadow private boolean disableCarvers;

	public boolean disableCarvers() {
		return true;
	}

	public boolean disableCarversActual() {
		return this.disableCarvers;
	}
}

