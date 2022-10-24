package drivermodbus.modbusserver;

import java.net.SocketTimeoutException;

class ClientConnectionThread extends Thread {
    private java.net.Socket socket;
    private byte[] inBuffer = new byte[1024];
    ModbusServer DriverModbusTCPServer;

    public ClientConnectionThread(java.net.Socket socket, ModbusServer DriverModbusTCPServer) {
        this.DriverModbusTCPServer = DriverModbusTCPServer;
        this.socket = socket;
    }

    public void run() {
        this.DriverModbusTCPServer
                .setNumberOfConnectedClients(this.DriverModbusTCPServer.getNumberOfConnectedClients() + 1);

        try {
            socket.setSoTimeout(DriverModbusTCPServer.getClientConnectionTimeout());
            java.io.InputStream inputStream;
            inputStream = socket.getInputStream();
            while (socket.isConnected() & !socket.isClosed() & !socket.isClosed()
                    & DriverModbusTCPServer.getServerRunning()) {

                int numberOfBytes = (inputStream.read(inBuffer));
                if (numberOfBytes == -1)
                    break;
                if (numberOfBytes > 4)
                    (new ProcessReceivedDataThread(inBuffer, DriverModbusTCPServer, socket)).start();
                Thread.sleep(5);
            }
            this.DriverModbusTCPServer
                    .setNumberOfConnectedClients(this.DriverModbusTCPServer.getNumberOfConnectedClients() - 1);
            socket.close();
        } catch (Exception e) {
            this.DriverModbusTCPServer
                    .setNumberOfConnectedClients(this.DriverModbusTCPServer.getNumberOfConnectedClients() - 1);
            try {
                socket.close();
            } catch (Exception exc) {
            }
            e.printStackTrace();
        }
    }

}
