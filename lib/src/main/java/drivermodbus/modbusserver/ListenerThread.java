package drivermodbus.modbusserver;

import java.io.IOException;

class ListenerThread extends Thread {
	ModbusServer DriverModbusTCPServer;

	public ListenerThread(ModbusServer DriverModbusTCPServer) {
		this.DriverModbusTCPServer = DriverModbusTCPServer;
	}

	public void run() {
		java.net.ServerSocket serverSocket = null;
		try {
			serverSocket = new java.net.ServerSocket(DriverModbusTCPServer.getPort());

			while (DriverModbusTCPServer.getServerRunning() & !this.isInterrupted()) {
				java.net.Socket socket = serverSocket.accept();
				(new ClientConnectionThread(socket, DriverModbusTCPServer)).start();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		if (serverSocket != null)
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
