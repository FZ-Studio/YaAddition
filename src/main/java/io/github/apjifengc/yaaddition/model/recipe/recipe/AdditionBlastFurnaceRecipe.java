
package io.github.apjifengc.yaaddition.model.recipe.recipe;

import org.bukkit.inventory.ItemStack;

import io.github.apjifengc.yaaddition.model.recipe.util.RecipeType;

import lombok.NonNull;

/**
 * 高炉配方
 */
public class AdditionBlastFurnaceRecipe extends AdditionCookingRecipe {
    /**
     * 新建空的高炉配方
     */
    public AdditionBlastFurnaceRecipe() {
        super(RecipeType.BLAST_FURNACE);
    }

    /**
     * 新建高炉配方
     * 
     * @param cookingResult     产品
     * @param cookingSource     材料
     * @param cookingExperience 经验
     * @param cookingTime       熔炼时间
     */
    public AdditionBlastFurnaceRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience, int cookingTime) {
        super(cookingSource, cookingResult, cookingExperience, cookingTime, RecipeType.BLAST_FURNACE);
    }

    public AdditionBlastFurnaceRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult,
            float cookingExperience) {
        super(cookingSource, cookingResult, cookingExperience, 100, RecipeType.BLAST_FURNACE);
    }

    public AdditionBlastFurnaceRecipe(@NonNull ItemStack cookingSource, @NonNull ItemStack cookingResult, int cookingTime) {
        super(cookingSource, cookingResult, 0, cookingTime, RecipeType.BLAST_FURNACE);
    }

    public AdditionBlastFurnaceRecipe(@NonNull ItemStack cookingResult, @NonNull ItemStack cookingSource) {
        super(cookingSource, cookingResult, 0, 100, RecipeType.BLAST_FURNACE);
    }

    @Override
    public boolean isIncorrectType() {
        return isIncorrectType(RecipeType.BLAST_FURNACE);
    }
}
