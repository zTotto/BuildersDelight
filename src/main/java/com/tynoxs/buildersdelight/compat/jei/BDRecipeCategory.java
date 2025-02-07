package com.tynoxs.buildersdelight.compat.jei;

import com.tynoxs.buildersdelight.BuildersDelight;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.Arrays;
import javax.annotation.Nullable;

public abstract class BDRecipeCategory<T> implements IRecipeCategory<T>
{
    protected final IGuiHelper guiHelper;
    private final RecipeType<T> type;
    public Component title;
    private IDrawableStatic background;
    private IDrawable icon;

    public BDRecipeCategory(IGuiHelper guiHelper, RecipeType<T> type, String localKey)
    {
        this.guiHelper = guiHelper;
        this.type = type;
        this.title = Component.translatable(localKey);
    }

    @Override
    public IDrawable getBackground()
    {
        return this.background;
    }

    protected void setBackground(IDrawableStatic background)
    {
        this.background = background;
    }

    @Nullable
    @Override
    public IDrawable getIcon()
    {
        return this.icon;
    }

    protected void setIcon(ItemStack stack)
    {
        this.setIcon(this.guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, stack));
    }

    protected void setIcon(IDrawable icon)
    {
        this.icon = icon;
    }

    @Override
    public Component getTitle()
    {
        return this.title;
    }

    @Override
    public final RecipeType<T> getRecipeType()
    {
        return type;
    }
}
