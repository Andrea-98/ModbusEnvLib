
package ModbusRTU;
import java.io.IOException;

import drivermodbus.exceptions.ModbusException;
import drivermodbus.modbusclient.ModbusClient;
import jssc.SerialPortException;
import jssc.SerialPortTimeoutException;


public class ModbusRTU 
{
     public static void main(String args[]) throws IOException, SerialPortException, ModbusException, SerialPortTimeoutException, InterruptedException
     {
    	 boolean success = false;
         ModbusClient modbusClient = new ModbusClient("127.0.0.1",502);
         System.out.println(modbusClient.Available(500));
         modbusClient.Connect();
         while (true)
         {
        	 System.out.println(modbusClient.ReadInputRegisters(0, 10)[5]);
        	 //Thread.sleep(200);
         }
         //modbusClient.WriteMultipleCoils(0, new boolean[] {true,true,true});
         //modbusClient.Disconnect();
         /*
         while (success == false)
         {
        	 try
        	 {
        		 modbusClient.Connect("127.0.0.1",502);
        		 boolean[] response = modbusClient.ReadCoils(2, 20);
        		 int[] responseint = modbusClient.ReadHoldingRegisters(0, 20);
        		 modbusClient.WriteSingleCoil(0, true);
        		 modbusClient.WriteSingleRegister(200, 456);
        		 modbusClient.WriteMultipleCoils(200, new boolean[]{true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true});
        		 modbusClient.WriteMultipleRegisters(300, new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});        
        		 for (int i = 0; i < response.length; i++)
        		 {
        			 System.out.println(response[i]);
        			 System.out.println(responseint[i]); 
        		 }
        		 success = true;  
        		 Thread.sleep(1000);
        	 }
        	 catch (Exception e)
        	 {
        		 e.printStackTrace();
        	 }
        	 finally
        	 {
        		 modbusClient.Disconnect();
        	 }
        	 
         }
         */
     }
}
