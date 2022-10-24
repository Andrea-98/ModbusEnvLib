
package drivermodbus.exceptions;


@SuppressWarnings("serial")
public class SerialPortException extends drivermodbus.exceptions.ModbusException
{
  public SerialPortException()
  {
  }

  public SerialPortException( String s )
  {
    super( s );
  }
}


