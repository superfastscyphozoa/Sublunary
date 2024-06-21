package net.superfastscyphozoa.sublunary.world.tree;

import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.superfastscyphozoa.sublunary.Sublunary;
import net.superfastscyphozoa.sublunary.mixin.TreeDecoratorTypeInvoker;
import net.superfastscyphozoa.sublunary.world.tree.decorator.BranchTreeDecorator;

public class SublunaryTreeDecoratorTypes {
	public static final TreeDecoratorType<?> BRANCH_TREE_DECORATOR =
			TreeDecoratorTypeInvoker.callRegister("branch_tree_decorator", BranchTreeDecorator.CODEC);

	public static void register() {
		Sublunary.LOGGER.info("registering tree decorators for " + Sublunary.MOD_ID);
	}
}
