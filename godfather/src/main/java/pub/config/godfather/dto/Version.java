package pub.config.godfather.dto;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by alexandru.ionita on 1/25/15.
 */
public class Version extends ResourceSupport implements Dto
{
    private short major;
    private short minor;
    private short patch;
    private String staging;

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

    public String getStaging()
    {
        return staging;
    }

    public void setStaging(String staging)
    {
        this.staging = staging;
    }
}
