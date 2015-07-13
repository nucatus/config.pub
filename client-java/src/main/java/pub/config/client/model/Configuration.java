package pub.config.client.model;

/**
 * Created by alexandru.ionita on 3/3/15.
 */
public class Configuration
{
    private String configurationName;
    private String configurationVersion;
    private String configurationEnvironment;

    private Configuration(final Builder builder)
    {
        this.configurationName = builder.configurationName;
        this.configurationVersion = builder.configurationVersion;
        this.configurationEnvironment = builder.configurationEnvironment;
    }

    public String getConfigurationName()
    {
        return configurationName;
    }

    public void setConfigurationName(String configurationName)
    {
        this.configurationName = configurationName;
    }

    public String getConfigurationVersion()
    {
        return configurationVersion;
    }

    public void setConfigurationVersion(String configurationVersion)
    {
        this.configurationVersion = configurationVersion;
    }

    public String getConfigurationEnvironment()
    {
        return configurationEnvironment;
    }

    public void setConfigurationEnvironment(String configurationEnvironment)
    {
        this.configurationEnvironment = configurationEnvironment;
    }

    public static final Builder builder()
    {
        return new Builder();
    }

    public static class Builder
    {
        private String configurationName;
        private String configurationVersion;
        private String configurationEnvironment;

        private Builder(){}

        public Builder configurationName(final String configurationName)
        {
            this.configurationName = configurationName;
            return this;
        }

        public String getConfigurationName()
        {
            return configurationName;
        }

        public Builder configurationVersion(final String configurationVersion)
        {
            this.configurationVersion = configurationVersion;
            return this;
        }

        public String getConfigurationVersion()
        {
            return configurationVersion;
        }

        public Builder configurationEnvironmane(final String configurationEnvironment)
        {
            this.configurationEnvironment = configurationEnvironment;
            return this;
        }

        public Configuration build()
        {
            return new Configuration(this);
        }
    }
}
