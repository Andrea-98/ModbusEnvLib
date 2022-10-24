

package drivermodbus.exceptions;


@SuppressWarnings("serial")
public class ConnectionException extends drivermodbus.exceptions.ModbusException
{
  public ConnectionException()
  {
  }

  public ConnectionException( String s )
  {
    super( s );
  }
}


