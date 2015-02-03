package pub.config.godfather.domain;

/**
 * Created by alexandru.ionita on 1/17/15.
 */
public class Version
{

    private short major;
    private short minor;
    private short patch;
    private VersionStaging staging;

    public short getMajor()
    {
        return major;
    }

    public void setMajor(short major)
    {
        this.major = major;
    }

    public short getMinor()
    {
        return minor;
    }

    public void setMinor(short minor)
    {
        this.minor = minor;
    }

    public short getPatch()
    {
        return patch;
    }

    public void setPatch(short patch)
    {
        this.patch = patch;
    }

    public VersionStaging getStaging()
    {
        return staging;
    }

    public void setStaging(VersionStaging versionStaging)
    {
        this.staging = versionStaging;
    }
}
