package tfar.unstabletools;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.RegisterEvent;
import tfar.unstabletools.init.ModBlocks;
import tfar.unstabletools.init.ModItems;

public class CreativeTab {
    private static final ResourceKey<CreativeModeTab> TOOLS = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(UnstableTools.MODID, "unstabletools"));
    public static void onCreativeModeTabRegister(RegisterEvent event) {
        event.register(Registries.CREATIVE_MODE_TAB, helper -> {
            helper.register(TOOLS, CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.unstable_axe))
                    .title(Component.literal("Unstable Tools"))
                    .withLabelColor(0x00FF00)
                    .displayItems(CreativeTab::accept)
                    .build());
        });
    }
    public static void onCreativeModeTabBuildContents(BuildCreativeModeTabContentsEvent event) {
        var entries = event.getEntries();
        var vis = CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;
        if (event.getTabKey() == TOOLS || event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            entries.put(i(ModItems.unstable_axe), vis);
            entries.put(i(ModItems.unstable_fishing_rod), vis);
            entries.put(i(ModItems.unstable_hoe), vis);
            entries.put(i(ModItems.unstable_pickaxe), vis);
            entries.put(i(ModItems.unstable_shears), vis);
            entries.put(i(ModItems.unstable_shovel), vis);
        } else if ( event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS ) {
            entries.put(i(ModBlocks.unstable_block), vis);
            entries.put(i(ModBlocks.ethereal_glass), vis);
        } else if ( event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS ) {
            entries.put(i(ModItems.inactive_division_sign), vis);
            entries.put(i(ModItems.division_sign), vis);
            entries.put(i(ModItems.stable_division_sign), vis);
            entries.put(i(ModItems.unstable_ingot), vis);
        } else if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            entries.put(i(ModItems.unstable_leggings), vis);
            entries.put(i(ModItems.unstable_boots), vis);
            entries.put(i(ModItems.unstable_helmet), vis);
            entries.put(i(ModItems.unstable_chestplate), vis);
            entries.put(i(ModItems.unstable_sword), vis);
            entries.put(i(ModItems.unstable_bow), vis);
        }
    }
    private static ItemStack i(ItemLike item) { return new ItemStack(item); }
    private static void accept(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output) {
        output.accept(i(ModItems.unstable_axe));
        output.accept(i(ModItems.unstable_shears));
        output.accept(i(ModItems.unstable_shovel));
        output.accept(i(ModItems.unstable_pickaxe));
        output.accept(i(ModItems.unstable_fishing_rod));
        output.accept(i(ModItems.unstable_hoe));
        output.accept(i(ModItems.unstable_bow));
        output.accept(i(ModItems.unstable_sword));
        output.accept(i(ModItems.unstable_boots));
        output.accept(i(ModItems.unstable_helmet));
        output.accept(i(ModItems.unstable_chestplate));
        output.accept(i(ModItems.unstable_leggings));
        output.accept(i(ModItems.unstable_ingot));
        output.accept(i(ModItems.division_sign));
        output.accept(i(ModItems.stable_division_sign));
        output.accept(i(ModItems.inactive_division_sign));
        output.accept(i(ModBlocks.ethereal_glass));
        output.accept(i(ModBlocks.unstable_block));
    }
}


