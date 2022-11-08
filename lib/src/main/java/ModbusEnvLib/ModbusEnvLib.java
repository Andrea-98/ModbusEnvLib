package ModbusEnvLib;

import dotenv.Dotenv;
import dotenv.DotenvException;
import dotenv.DotenvEntry;


import java.util.HashMap;
import java.util.Map;



import java.util.Iterator;
import java.util.Set;

import drivermodbus.modbusclient.*;


public class ModbusEnvLib{

    public ModbusEnvLib() {
    }

    @Override
    public String toString() {
        return "ModbusEnvLib []";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @SuppressWarnings("deprecation")
	@Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
    
    public static void main(String[] args) {

            //// ----------TEST----------------//// 
            
        ModbusClient modbusClient = new ModbusClient("192.168.0.1",502);   // define ip address and port (ip address is a string while the port is an int)
        try
        {
            modbusClient.Connect(); //to establish the Modbus TCP/IP connection
            System.out.println(modbusClient.ReadCoils(0, 1)[0]);  //function to read the coils (repeat for each coil to be read, the number in square brackets always leave at zero)
            System.out.println(modbusClient.ReadHoldingRegisters(0, 1)[0]);
            System.out.println(modbusClient.ReadHoldingRegisters(25, 1)[0]);//function to read the holding registers (repeat for each holding register to be read, the number in square brackets always leave at zero)
            modbusClient.WriteSingleCoil(1, true);  //to write on a single coil
            modbusClient.WriteSingleRegister(2, 1234); //to write to a single register

		}
		catch (Exception e)
		{

    }

}}