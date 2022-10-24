
package drivermodbus.exceptions;


@SuppressWarnings("serial")
public class CRCCheckFailedException extends drivermodbus.exceptions.ModbusException
{
  public CRCCheckFailedException()
  {
  }

  public CRCCheckFailedException( String s )
  {
    super( s );
  }
}


