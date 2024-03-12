package net.superfastscyphozoa.sublunary.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.superfastscyphozoa.sublunary.entity.BadgerEntity;
import net.superfastscyphozoa.sublunary.entity.animation.SublunaryAnimations;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class BadgerModel<T extends BadgerEntity> extends SinglePartEntityModel<T> {

	private final ModelPart body;
	private final ModelPart head;

	public BadgerModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = body.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -3.0F, -8.0F, 12.0F, 7.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 17.0F, 1.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 23).cuboid(-4.5F, 0.0F, -9.0F, 10.0F, 4.0F, 9.0F, new Dilation(0.0F))
		.uv(40, 0).cuboid(2.5F, -3.0F, -2.0F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(24, 36).cuboid(-4.5F, -3.0F, -2.0F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F))
		.uv(38, 46).cuboid(-1.5F, 0.0F, -12.0F, 4.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -3.0F, -8.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData leg0 = body.addChild("leg0", ModelPartBuilder.create().uv(0, 0).cuboid(-1.499F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.5F, 4.0F, 4.5F));

		ModelPartData leg1 = body.addChild("leg1", ModelPartBuilder.create().uv(0, 6).cuboid(-1.501F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(4.5F, 4.0F, 4.5F));

		ModelPartData leg2 = body.addChild("leg2", ModelPartBuilder.create().uv(0, 36).cuboid(-1.499F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.5F, 4.0F, -6.5F));

		ModelPartData leg3 = body.addChild("leg3", ModelPartBuilder.create().uv(12, 36).cuboid(-1.501F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(4.5F, 4.0F, -6.5F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(29, 23).cuboid(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 8.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(BadgerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(SublunaryAnimations.BADGER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, SublunaryAnimations.BADGER_IDLE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return body;
	}
}