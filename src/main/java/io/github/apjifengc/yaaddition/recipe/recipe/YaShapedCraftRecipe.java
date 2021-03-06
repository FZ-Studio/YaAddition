package io.github.apjifengc.yaaddition.recipe.recipe;

import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

import org.bukkit.inventory.ItemStack;

import lombok.NonNull;

/**
 * 有序合成
 */
public class YaShapedCraftRecipe extends YaCraftingRecipe {
    /**
     * 新建空的有序合成
     */
    public YaShapedCraftRecipe() {
        super(RecipeType.SHAPED_CRAFT);
    }

    /**
     * 新建有序合成
     * 
     * @param craftingSource 材料，按九宫格从左到右从上到下的顺序，最多九堆
     * @param craftingResult 产品
     */
    public YaShapedCraftRecipe(@NonNull ItemStack[] craftingSource, @NonNull ItemStack craftingResult) {
        super(craftingSource, craftingResult, RecipeType.SHAPED_CRAFT);
    }

    @Override
    public boolean isIncorrectType() {
        return isIncorrectType(RecipeType.SHAPED_CRAFT);
    }
}
