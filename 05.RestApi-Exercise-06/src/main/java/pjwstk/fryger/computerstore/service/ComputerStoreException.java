package pjwstk.fryger.computerstore.service;

import javax.ejb.ApplicationException;

@ApplicationException
public class ComputerStoreException extends RuntimeException
{
    public ComputerStoreException(String message)
    {
        super(message);
    }
}
