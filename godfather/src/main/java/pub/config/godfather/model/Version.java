package pub.config.godfather.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author alexandru.ionita
 * @since 1.0
 */
public class Version implements Comparable<Version>
{
    private int major;
    private int minor;
    private int patch;
    private VersionStage stage;

    public int getMajor()
    {
        return major;
    }

    public void setMajor(int major)
    {
        this.major = major;
    }

    public int getMinor()
    {
        return minor;
    }

    public void setMinor(int minor)
    {
        this.minor = minor;
    }

    public int getPatch()
    {
        return patch;
    }

    public void setPatch(int patch)
    {
        this.patch = patch;
    }

    public VersionStage getStage()
    {
        return stage;
    }

    public void setStage(VersionStage stage)
    {
        this.stage = stage;
    }

    @Override
    public int compareTo(Version o)
    {
        if (o == null)
        {
            return -1;
        }
        if (this.major == o.major)
        {
            if (this.minor == o.minor)
            {
                if (this.getPatch() == o.patch)
                {
                    if (this.stage == o.stage)
                    {
                        return 0;
                    }
                    else
                    {
                        return this.stage.order - o.stage.order;
                    }
                }
                else
                {
                    return this.patch - o.patch;
                }
            }
            else
            {
                return this.minor - o.minor;
            }
        }
        else
        {
            return this.major - o.major;
        }
    }

    public enum VersionStage
    {
        ALPHA(0), BETA(10), RELEASE(20);

        private int order;

        static Map<Integer, VersionStage> lookup = new HashMap<>();

        static
        {
            for (VersionStage vs : VersionStage.values())
            {
                lookup.put(vs.getOrder(), vs);
            }
        }

        VersionStage(int order)
        {
            this.order = order;
        }

        public int getOrder()
        {
            return order;
        }

        public static VersionStage lookup(int id)
        {
            return lookup.get(id);
        }
    }
}
