
package drivermodbus.exceptions;


@SuppressWarnings("serial")
public class StartingAddressInvalidException extends drivermodbus.exceptions.ModbusException
{
  public StartingAddressInvalidException()
  {
  }

  public StartingAddressInvalidException( String s )
  {
    super( s );
  }
}


