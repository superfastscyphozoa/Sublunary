package net.superfastscyphozoa.sublunary.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class PasserineAnimations {

        public static final Animation PASSERINEIDLE = Animation.Builder.create(1f).looping()
                .addBoneAnimation("body",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, -0.1f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
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
                                new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(1f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.8343334f, AnimationHelper.createRotationalVector(-1f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("wing2",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.3433333f, AnimationHelper.createRotationalVector(1f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.8343334f, AnimationHelper.createRotationalVector(-1f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("tail",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0.1f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("tail",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0.5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR))).build();

        public static final Animation PASSERINEFLY = Animation.Builder.create(0.25f).looping()
                .addBoneAnimation("body",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.08343333f, AnimationHelper.createTranslationalVector(0f, 0.3f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("body",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(3.5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(3f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(3.5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leg1",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(50f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(57.5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(50f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leg2",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(50f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(57.5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(50f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("wing1",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createTranslationalVector(0.3f, -1f, 1f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("wing1",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(-35f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(-35f, 0f, 120f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(-35f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("wing2",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createTranslationalVector(-0.3f, -1f, 1f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("wing2",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(-35f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(-35f, 0f, -120f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(-35f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("tail",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(4f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR))).build();

        public static final Animation PASSERINEHOP = Animation.Builder.create(0.5f).looping()
                .addBoneAnimation("body",
                        new Transformation(Transformation.Targets.TRANSLATE,
                                new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createTranslationalVector(0f, 0.6f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.4167667f, AnimationHelper.createTranslationalVector(0f, 0.6f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("body",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(0f, 2.5f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.4167667f, AnimationHelper.createRotationalVector(0f, -2.5f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leg1",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(-35f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.4167667f, AnimationHelper.createRotationalVector(35f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("leg2",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(35f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.4167667f, AnimationHelper.createRotationalVector(-35f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("wing1",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.125f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.375f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("wing2",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.125f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.375f, AnimationHelper.createRotationalVector(10f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR)))
                .addBoneAnimation("tail",
                        new Transformation(Transformation.Targets.ROTATE,
                                new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.16766666f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.4167667f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR),
                                new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                        Transformation.Interpolations.LINEAR))).build();
}
