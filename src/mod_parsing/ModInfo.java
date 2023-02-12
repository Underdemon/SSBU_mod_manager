package mod_parsing;

import java.util.ArrayList;

public class ModInfo<T>
{
    private T modName;
    private T charName;

    public ModInfo(T modName, T charName)
    {
        this.modName    = modName;
        this.charName   = charName;
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

    public void outputModData()
    {
        System.out.println("\n" + this.modName + "\n" + this.charName);
    }

    @Override
    public boolean equals(Object o)
    {
        if(((ModInfo<?>) o).getModName().equals(modName) && ((ModInfo<?>) o).getCharName().equals(charName))
            return true;
        else
        return false;
    }

    @Override
    public int hashCode()
    {
        return getCharName().hashCode() + getModName().hashCode();
    }
}
