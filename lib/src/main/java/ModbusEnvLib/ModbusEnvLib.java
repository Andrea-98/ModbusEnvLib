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
      /*      
            ModbusClient modbusClient = new ModbusClient("192.168.0.1",502);
		try
		{
			modbusClient.Connect();
			System.out.println(modbusClient.ReadCoils(0, 1)[0]);
			System.out.println(modbusClient.ReadHoldingRegisters(0, 1)[0]);
			
		}
		catch (Exception e)
		{

    }*/

}}