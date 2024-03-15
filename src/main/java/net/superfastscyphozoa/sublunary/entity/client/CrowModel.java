package net.superfastscyphozoa.sublunary.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.superfastscyphozoa.sublunary.entity.CrowEntity;
import net.superfastscyphozoa.sublunary.entity.animation.SublunaryAnimations;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class CrowModel<T extends CrowEntity> extends SinglePartEntityModel<T> {

	private final ModelPart crow;
	private final ModelPart head;

	public CrowModel(ModelPart root) {
		this.crow = root.getChild("crow");
		this.head = crow.getChild("body").getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData crow = modelPartData.addChild("crow", ModelPartBuilder.create(), ModelTransform.pivot(-0.5F, 24.0F, 0.0F));

		ModelPartData body = crow.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -5.0F, -2.0F, 3.0F, 3.0F, 5.0F, new Dilation(0.0F))
				.uv(11, 0).cuboid(-1.0F, -5.0F, 3.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
				.uv(11, 3).cuboid(-1.0F, -4.0F, 3.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(14, 5).cuboid(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
				.uv(14, 11).cuboid(-0.5F, -1.0F, -5.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -5.0F, -1.0F));

		ModelPartData leg1 = body.addChild("leg1", ModelPartBuilder.create().uv(2, 2).cuboid(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(-1.0F, 2.0F, -1.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData leg2 = body.addChild("leg2", ModelPartBuilder.create().uv(0, 2).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(0.0F, 2.0F, -1.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -2.0F, 0.0F));

		ModelPartData wing1 = body.addChild("wing1", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, -5.0F, -1.7F));

		ModelPartData cube_r1 = wing1.addChild("cube_r1", ModelPartBuilder.create().uv(0, 8).cuboid(-4.0F, 0.0F, 0.3F, 1.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 0.0F, -0.3F, -0.1309F, 0.0F, 0.0F));

		ModelPartData wing2 = body.addChild("wing2", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, -5.0F, -1.7F));

		ModelPartData cube_r2 = wing2.addChild("cube_r2", ModelPartBuilder.create().uv(7, 10).cuboid(0.0F, 0.0F, 0.3F, 1.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -0.3F, -0.1309F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(CrowEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(SublunaryAnimations.CROWFLY, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, SublunaryAnimations.CROWIDLE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		crow.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return crow;
	}
}