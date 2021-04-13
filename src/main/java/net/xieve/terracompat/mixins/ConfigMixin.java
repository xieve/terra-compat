package net.xieve.terracompat.mixins;

import com.dfsek.terra.config.pack.ConfigPackTemplate;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ConfigPackTemplate.class)
public abstract class ConfigMixin {
	public boolean disableCarvers() {
		return true;
	}
}
