package xuan.cat.packetwhitelistnbt.code.branch.v20;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.Recipe;
import xuan.cat.packetwhitelistnbt.api.branch.BranchPacket;
import xuan.cat.packetwhitelistnbt.api.branch.packet.*;

import java.util.function.Function;

public final class Branch_20_Packet implements BranchPacket {
    @Override
    public void convertSetSlot(PacketSetSlotEvent event, Function<ItemStack, ItemStack> convert) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void convertWindowItems(PacketWindowItemsEvent event, Function<ItemStack, ItemStack> convert) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void convertWindowMerchants(PacketOpenWindowMerchantEvent event, Function<MerchantRecipe, MerchantRecipe> convert) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void convertEntityEquipment(PacketEntityEquipmentEvent event, Function<ItemStack, ItemStack> convert) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void convertRecipeUpdate(PacketRecipeUpdateEvent event, Function<Recipe, Recipe> convert) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void convertEntityMetadata(PacketEntityMetadataEvent event, Function<ItemStack, ItemStack> convert) {
        throw new UnsupportedOperationException();
    }
}
