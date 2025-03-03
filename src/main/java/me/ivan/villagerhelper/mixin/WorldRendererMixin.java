package me.ivan.villagerhelper.mixin;

import me.ivan.villagerhelper.VillagerHelper;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class WorldRendererMixin
{
    // just like onRenderWorldLast in malilib
    @Inject(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    ordinal = 1,
                    target = "Lnet/minecraft/client/render/WorldRenderer;renderWeather(Lnet/minecraft/client/render/LightmapTextureManager;FDDD)V"
            )
    )
    private void render(MatrixStack matrices, float tickDelta, long limitTime, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightmapTextureManager lightmapTextureManager, Matrix4f matrix4f, CallbackInfo ci) {
        VillagerHelper.getInstance().renderVillagerInfo(tickDelta);
    }
}
