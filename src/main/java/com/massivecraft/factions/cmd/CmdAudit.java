package com.massivecraft.factions.cmd;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.zcore.faudit.FAuditMenu;
import com.massivecraft.factions.zcore.util.TL;
import org.bukkit.entity.Player;

public class CmdAudit extends FCommand {

    public CmdAudit() {
        super();
        this.aliases.add("audit");
        this.aliases.add("logs");
        this.aliases.add("log");


        this.requirements = new CommandRequirements.Builder(Permission.AUDIT)
                .playerOnly()
                .memberOnly()
                .noErrorOnManyArgs()
                .build();
    }
    @Override
    public void perform(CommandContext context) {
        Faction faction = context.args.size() == 1 && context.sender.isOp() ? context.argAsFaction(0) : context.faction;
        new FAuditMenu((Player)context.sender, faction).open((Player)context.sender);
    }

    @Override
    public TL getUsageTranslation() {
        return null;
    }
}
