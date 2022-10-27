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
            
        ModbusClient modbusClient = new ModbusClient("192.168.0.1",502);   // definire indirizzo ip e porta ( indirizzo ip è una stringa mentre la porta è un int)
        try
        {
            modbusClient.Connect(); //per stabilire la connessione modbus tcp/ip
            System.out.println(modbusClient.ReadCoils(0, 1)[0]);  //funzione per legere i coils (ripetere per ogni coil da leggere, il numero compreso tra parentesi quadre lasciare sempre a zero)
            System.out.println(modbusClient.ReadHoldingRegisters(0, 1)[0]);
            System.out.println(modbusClient.ReadHoldingRegisters(25, 1)[0]);//funzione per legere gli holding register (ripetere per ogni holding register da leggere, il numero compreso tra parentesi quadre lasciare sempre a zero)
            modbusClient.WriteSingleCoil(1, true);  //per scrivere su singolo coil
            modbusClient.WriteSingleRegister(2, 1234); //per scrivere su singolo registro

		}
		catch (Exception e)
		{

    }

}}