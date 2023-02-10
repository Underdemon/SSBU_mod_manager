package mod_parsing;

import java.util.ArrayList;

public class ModInfo<T>
{
    private T modName;
    private T charName;
    private T slotName;

    public ModInfo(T modName, T charName, T slotName)
    {
        this.modName    = modName;
        this.charName   = charName;
        this.slotName   = slotName;
    }

    public T getModName()
    {
        return modName;
    }

    public void setModName(T modName)
    {
        this.modName = modName;
    }

    public T getCharName()
    {
        return charName;
    }

    public void setCharName(T charName)
    {
        this.charName = charName;
    }

    public T getSlotName()
    {
        return slotName;
    }

    public void setSlotName(T slotName)
    {
        this.slotName = slotName;
    }
}
