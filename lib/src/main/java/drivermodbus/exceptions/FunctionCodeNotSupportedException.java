
package drivermodbus.exceptions;


@SuppressWarnings("serial")
public class FunctionCodeNotSupportedException extends drivermodbus.exceptions.ModbusException
{
  public FunctionCodeNotSupportedException()
  {
  }

  public FunctionCodeNotSupportedException( String s )
  {
    super( s );
  }
}


