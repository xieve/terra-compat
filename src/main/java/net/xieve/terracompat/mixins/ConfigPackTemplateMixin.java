package net.xieve.terracompat.mixins;

import com.dfsek.terra.config.pack.ConfigPackTemplate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ConfigPackTemplate.class, remap = false)
public abstract class ConfigPackTemplateMixin {
	@Shadow private boolean vanillaCaves;
	@Shadow private boolean vanillaStructures;

	@Inject(at = @At("TAIL"), method = "<init>")
	private void init(CallbackInfo ci) {
		this.vanillaCaves = true;
		this.vanillaStructures = true;
		System.out.println("ConfigPackTemplate default values overridden.");
	}

	public boolean disableCarvers() {
		return this.vanillaCaves;
	}
}

