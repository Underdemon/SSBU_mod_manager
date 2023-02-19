package mod_parsing;
public class ModInfo
{
    private String modName;
    private String dir;
    public ModInfo(String modName, String dir)
    {
        this.modName    = modName;
        this.dir        = dir;
    }

    public String getModName()
    {
        return modName;
    }

    public void setModName(String modName)
    {
        this.modName = modName;
    }

    public String getDir()
    {
        return dir;
    }

    public void setDir(String dir)
    {
        this.dir = dir;
    }

    @Override
    public int hashCode()
    {
        return modName.hashCode() + dir.hashCode();
    }
}
