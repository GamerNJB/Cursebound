package com.gameidiots.cursebound;

import net.minecraft.nbt.NbtCompound;

public class CurseComponent
{
    private static final String CURSE_TYPE_KEY = "CurseType";
    private CurseType curseType;

    public CurseComponent()
    {
        this.curseType = CurseType.NONE;
    }

    public CurseType getCurseType()
    {
        return this.curseType;
    }

    public void setCurseType(CurseType curseType)
    {
        this.curseType = curseType;
    }

    public void readNbt(NbtCompound nbt)
    {
        if (nbt.contains(CURSE_TYPE_KEY))
        {
            String stringValue = nbt.getString(CURSE_TYPE_KEY);
            if (!stringValue.isEmpty())
            {
                this.curseType = CurseType.valueOf(stringValue);
            }
        }
    }

    public void writeNbt(NbtCompound nbt)
    {
        if (this.curseType != CurseType.NONE)
        {
            nbt.putString(CURSE_TYPE_KEY, this.curseType.name());
        }
    }
}
