package pub.config.client;

/**
 * Created by alexandru.ionita on 7/3/15.
 */
public class ClientCertificatesException extends Exception
{
    public ClientCertificatesException(String message)
    {
        super(message);
    }

    public ClientCertificatesException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ClientCertificatesException(Throwable cause)
    {
        super(cause);
    }
}
