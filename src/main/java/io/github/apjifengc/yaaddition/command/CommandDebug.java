package io.github.apjifengc.yaaddition.command;

import com.rabbitown.yalib.module.command.CommandSenderType;
import com.rabbitown.yalib.module.command.SimpleCommandRemote;
import com.rabbitown.yalib.module.command.annotation.*;
import io.github.apjifengc.yaaddition.YaAddition;
import io.github.apjifengc.yaaddition.addition.AdditionItemStack;
import io.github.apjifengc.yaaddition.addition.AdditionMaterial;
import io.github.apjifengc.yaaddition.core.state.TripWireState;
import io.github.apjifengc.yaaddition.util.Data;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

@Path(path = "debug")
public class CommandDebug extends SimpleCommandRemote {
    public CommandDebug() {
        super("yaaddition", YaAddition.getInstance(), Arrays.asList("yadd"), "The main command for yaaddition.", "/yaaddition help");
    }

    @Action(action = "setId")
    @Parameter(params = {"sender", "id"})
    @Access(sender = {CommandSenderType.PLAYER})
    public void setId(Player sender, int id) {
        new TripWireState(id).setData(sender.getLocation().getBlock());
    }

    @Action(action = "testItem")
    @Parameter(params = {"sender"})
    @Access(sender = {CommandSenderType.PLAYER})
    public void testItem(Player sender) {
        AdditionItemStack itemStack = new AdditionItemStack("TEST_ITEM");
        Data data = itemStack.getData();
        data.set("test", "test", 0, "t");
        data.set(false, "test", 0, "x");
        System.out.println(data.get("test", 0));
        System.out.println(data.getString("test", 0, "t"));
        System.out.println(data);
        sender.getInventory().addItem(itemStack.asBukkitCopy());
    }
}