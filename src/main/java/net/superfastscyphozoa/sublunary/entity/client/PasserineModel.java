package net.superfastscyphozoa.sublunary.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.superfastscyphozoa.sublunary.entity.PasserineEntity;
import net.superfastscyphozoa.sublunary.entity.animation.PasserineAnimations;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class PasserineModel<T extends PasserineEntity> extends SinglePartEntityModel<T> {

	private final ModelPart passerine;
	private final ModelPart head;

	public PasserineModel(ModelPart root) {
		this.passerine = root.getChild("passerine");
		this.head = passerine.getChild("body").getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData passerine = modelPartData.addChild("passerine", ModelPartBuilder.create(), ModelTransform.pivot(-0.5F, 24.0F, 0.0F));

		ModelPartData body = passerine.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = body.addChild("cube_r1", ModelPartBuilder.create().uv(0, 23).cuboid(-1.0F, -0.0287F, -4.7804F, 3.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.5F, 1.5F, -0.9599F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(20, 25).cuboid(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
				.uv(25, 0).cuboid(-0.5F, -1.0F, -5.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -7.4F, -1.2F));

		ModelPartData leg1 = body.addChild("leg1", ModelPartBuilder.create().uv(2, 2).cuboid(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 1).cuboid(-1.0F, 2.0F, -1.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, -0.7F));

		ModelPartData leg2 = body.addChild("leg2", ModelPartBuilder.create().uv(0, 2).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(0.0F, 2.0F, -1.0F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -2.0F, -0.7F));

		ModelPartData wing1 = body.addChild("wing1", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, -7.0F, -1.7F));

		ModelPartData cube_r2 = wing1.addChild("cube_r2", ModelPartBuilder.create().uv(17, 12).cuboid(-4.0F, 0.0F, -0.7F, 1.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 0.5F, 0.6F, -0.6981F, 0.0F, 0.0F));

		ModelPartData wing2 = body.addChild("wing2", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, -7.0F, -1.7F));

		ModelPartData cube_r3 = wing2.addChild("cube_r3", ModelPartBuilder.create().uv(1, 12).cuboid(0.0F, -0.6428F, 0.066F, 1.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5F, -0.4F, -0.6981F, 0.0F, 0.0F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, -3.2F, -0.1F));

		ModelPartData cube_r4 = tail.addChild("cube_r4", ModelPartBuilder.create().uv(9, 11).cuboid(-1.0F, -4.4F, -1.6F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 4.7F, -0.4F, -0.4363F, 0.0F, 0.0F));

		ModelPartData cube_r5 = tail.addChild("cube_r5", ModelPartBuilder.create().uv(7, 1).cuboid(-1.5F, -0.0232F, -0.2995F, 3.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.3F, 1.6F, -0.4363F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(PasserineEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		//this.animateMovement(PasserineAnimations.PASSERINEFLY, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, PasserineAnimations.PASSERINEIDLE, ageInTicks, 1f);
		this.updateAnimation(entity.flyAnimationState, PasserineAnimations.PASSERINEFLY, ageInTicks, 1f);
		this.updateAnimation(entity.hopAnimationState, PasserineAnimations.PASSERINEHOP, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		passerine.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return passerine;
	}
}