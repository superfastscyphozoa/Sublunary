package net.superfastscyphozoa.sublunary.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class SublunaryAnimations {

        //Crow
        public static final Animation CROWFLY = Animation.Builder.create(0.5f).looping()
                .addBoneAnimation("body",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0.3f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leg1",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(45f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(52.5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(45f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leg2",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(45f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(52.5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(45f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("wing1",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("wing1",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.125f, AnimationHelper.createRotationalVector(20f, -45f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.375f, AnimationHelper.createRotationalVector(25f, -45f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("wing2",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("wing2",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.125f, AnimationHelper.createRotationalVector(20f, 45f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.375f, AnimationHelper.createRotationalVector(25f, 45f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR))).build();

        public static final Animation CROWIDLE = Animation.Builder.create(1f).looping()
                .addBoneAnimation("body",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, -0.1f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("body",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leg1",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leg2",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("wing1",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.2916767f, AnimationHelper.createRotationalVector(1f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.7916766f, AnimationHelper.createRotationalVector(-1f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("wing2",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.2916767f, AnimationHelper.createRotationalVector(1f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.7916766f, AnimationHelper.createRotationalVector(-1f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR))).build();
    
}
