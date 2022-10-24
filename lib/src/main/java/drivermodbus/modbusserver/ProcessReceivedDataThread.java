package drivermodbus.modbusserver;

import java.util.Calendar;

class ProcessReceivedDataThread extends Thread {
    short[] inBuffer;
    ModbusServer DriverModbusTCPServer;
    java.net.Socket socket;

    public ProcessReceivedDataThread(byte[] inBuffer, ModbusServer DriverModbusTCPServer, java.net.Socket socket) {
        this.socket = socket;
        this.inBuffer = new short[inBuffer.length];
        for (int i = 0; i < inBuffer.length; i++) {

            this.inBuffer[i] = (short) ((short) inBuffer[i] & 0xff);
        }
        this.DriverModbusTCPServer = DriverModbusTCPServer;
    }

    public void run() {

        synchronized (DriverModbusTCPServer) {
            short[] wordData = new short[1];
            short[] byteData = new short[2];
            DriverModbusTCPServer.receiveData = new ModbusProtocoll();
            DriverModbusTCPServer.receiveData.timeStamp = Calendar.getInstance();
            DriverModbusTCPServer.receiveData.request = true;

            // Lese Transaction identifier
            byteData[1] = inBuffer[0];
            byteData[0] = inBuffer[1];
            wordData[0] = (short) byteArrayToInt(byteData);
            DriverModbusTCPServer.receiveData.transactionIdentifier = wordData[0];

            // Lese Protocol identifier
            byteData[1] = inBuffer[2];
            byteData[0] = inBuffer[3];
            wordData[0] = (short) byteArrayToInt(byteData);
            DriverModbusTCPServer.receiveData.protocolIdentifier = wordData[0];

            // Lese length
            byteData[1] = inBuffer[4];
            byteData[0] = inBuffer[5];
            wordData[0] = (short) byteArrayToInt(byteData);
            DriverModbusTCPServer.receiveData.length = wordData[0];

            // Lese unit identifier
            DriverModbusTCPServer.receiveData.unitIdentifier = (byte) inBuffer[6];

            // Lese function code
            DriverModbusTCPServer.receiveData.functionCode = (byte) inBuffer[7];

            // Lese starting address
            byteData[1] = inBuffer[8];
            byteData[0] = inBuffer[9];
            wordData[0] = (short) byteArrayToInt(byteData);
            DriverModbusTCPServer.receiveData.startingAdress = wordData[0];

            if (DriverModbusTCPServer.receiveData.functionCode <= 4) {
                // Lese quantity
                byteData[1] = inBuffer[10];
                byteData[0] = inBuffer[11];
                wordData[0] = (short) byteArrayToInt(byteData);
                DriverModbusTCPServer.receiveData.quantity = wordData[0];
            }
            if (DriverModbusTCPServer.receiveData.functionCode == 5) {
                DriverModbusTCPServer.receiveData.receiveCoilValues = new short[1];
                // Lese Value
                byteData[0] = inBuffer[10];
                byteData[1] = inBuffer[11];
                DriverModbusTCPServer.receiveData.receiveCoilValues[0] = (short) byteArrayToInt(byteData);
            }
            if (DriverModbusTCPServer.receiveData.functionCode == 6) {
                DriverModbusTCPServer.receiveData.receiveRegisterValues = new int[1];
                // Lese Value
                byteData[1] = inBuffer[10];
                byteData[0] = inBuffer[11];
                DriverModbusTCPServer.receiveData.receiveRegisterValues[0] = byteArrayToInt(byteData);
            }
            if (DriverModbusTCPServer.receiveData.functionCode == 15) {
                // Lese quantity
                byteData[1] = inBuffer[10];
                byteData[0] = inBuffer[11];
                wordData[0] = (short) byteArrayToInt(byteData);
                DriverModbusTCPServer.receiveData.quantity = wordData[0];

                DriverModbusTCPServer.receiveData.byteCount = (byte) inBuffer[12];

                if ((DriverModbusTCPServer.receiveData.byteCount % 2) != 0)
                    DriverModbusTCPServer.receiveData.receiveCoilValues = new short[DriverModbusTCPServer.receiveData.byteCount
                            / 2 + 1];
                else
                    DriverModbusTCPServer.receiveData.receiveCoilValues = new short[DriverModbusTCPServer.receiveData.byteCount
                            / 2];
                // Lese Value
                for (int i = 0; i < DriverModbusTCPServer.receiveData.byteCount; i++) {
                    if ((i % 2) == 1)
                        DriverModbusTCPServer.receiveData.receiveCoilValues[i
                                / 2] = (short) (DriverModbusTCPServer.receiveData.receiveCoilValues[i / 2]
                                        + 256 * inBuffer[13 + i]);
                    else
                        DriverModbusTCPServer.receiveData.receiveCoilValues[i / 2] = inBuffer[13 + i];
                }
            }
            if (DriverModbusTCPServer.receiveData.functionCode == 16) {
                // Lese quantity
                byteData[1] = inBuffer[10];
                byteData[0] = inBuffer[11];
                wordData[0] = (short) byteArrayToInt(byteData);
                DriverModbusTCPServer.receiveData.quantity = wordData[0];

                DriverModbusTCPServer.receiveData.byteCount = (byte) inBuffer[12];
                DriverModbusTCPServer.receiveData.receiveRegisterValues = new int[DriverModbusTCPServer.receiveData.quantity];
                for (int i = 0; i < DriverModbusTCPServer.receiveData.quantity; i++) {
                    // Lese Value
                    byteData[1] = inBuffer[13 + i * 2];
                    byteData[0] = inBuffer[14 + i * 2];
                    DriverModbusTCPServer.receiveData.receiveRegisterValues[i] = byteData[0];
                    DriverModbusTCPServer.receiveData.receiveRegisterValues[i] = (int) (DriverModbusTCPServer.receiveData.receiveRegisterValues[i]
                            + (byteData[1] << 8));
                }
            }
            DriverModbusTCPServer.CreateAnswer(socket);
            DriverModbusTCPServer.CreateLogData();
        }
    }

    public int byteArrayToInt(short[] byteArray) {
        int returnValue;
        returnValue = byteArray[0];
        returnValue = (int) (returnValue + 256 * byteArray[1]);
        return returnValue;
    }

}
