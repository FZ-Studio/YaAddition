package io.github.apjifengc.yaaddition.recipe.recipe;

import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import io.github.apjifengc.yaaddition.recipe.excption.RecipeException;
import io.github.apjifengc.yaaddition.recipe.util.RecipeType;

/**
 * 酿造配方
 */
public class YaBrewingStandRecipe extends YaRecipe {

    @Getter
    @Setter
    private ItemStack ingredient;
    @Getter
    @Setter
    private ItemStack potion;

    /**
     * 新建空的酿造配方
     */
    public YaBrewingStandRecipe() {
        this.type = RecipeType.BREWING_STAND;
    }

    /**
     * 新建酿造配方
     */
    public YaBrewingStandRecipe(@NonNull ItemStack ingredient, @NonNull ItemStack potion,
            @NonNull ItemStack brewingResult) {
        this.ingredient = ingredient;
        this.potion = potion;
        this.result = brewingResult;
        this.type = RecipeType.BREWING_STAND;
        namespacedKeyGen(this.result, this.type);
    }

    @Override
    public void save() throws IOException, RecipeException {
        selfCheck();
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", this.type);
        map.put("result", this.result);
        map.put("ingredient", this.ingredient);
        map.put("potion", this.potion);
        save(map);
    }

    /**
     * @param file 配方文件
     */
    @Override
    public void load(@NonNull File file) throws IOException, RecipeException, ClassNotFoundException {
        try (BukkitObjectInputStream ois = new BukkitObjectInputStream(new FileInputStream(file));) {
            HashMap<String, Object> map = new HashMap<>();
            Object readMap = ois.readObject();

            if (readMap instanceof HashMap) {
                map.putAll((HashMap) readMap);
                setResult((ItemStack) map.get("result"));
                this.ingredient = (ItemStack) map.get("ingredient");
                this.potion = (ItemStack) map.get("potion");
                this.type = (RecipeType) map.get("type");
            }
        }
        selfCheck();
    }

    @Override
    public boolean isIncomplete() {
        return this.ingredient == null || this.potion == null || this.result == null;
    }

    @Override
    public boolean isIncorrectType() {
        return isIncorrectType(RecipeType.BREWING_STAND);
    }
}
