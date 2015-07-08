package de.tudresden.io;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TwoWaySerialComm {

	private final static int TIMEOUT = 2000;
	private final static int DATA_RATE = 9600;
	
	void connect(String portName) throws Exception {
		System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");
		
		CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
		if (portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
		} else {
			int timeout = TIMEOUT;
			CommPort commPort = portIdentifier.open(this.getClass().getName(), timeout);

			if (commPort instanceof SerialPort) {
				SerialPort serialPort = (SerialPort) commPort;
				serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8,
						SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

				InputStream in = serialPort.getInputStream();
				OutputStream out = serialPort.getOutputStream();

				(new Thread(new SerialReader(in))).start();
				(new Thread(new SerialWriter(out))).start();

			} else {
				System.out.println("Error: Only serial ports are handled by this example.");
			}
		}
	}

	public static class SerialReader implements Runnable {

		InputStream in;
		List<String> queue = new ArrayList<String>();

		public SerialReader(InputStream in) {
			this.in = in;
		}

		public void run() {
			byte[] buffer = new byte[1024];
			int len = -1;
			try {
				while ((len = this.in.read(buffer)) > -1) {
					System.out.print(new String(buffer, 0, len));
					queue.add(new String(buffer, 0, len));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public List<String> getQueueAndErase(){
			List<String> newQueue = queue;
			queue = new ArrayList<String>();
			return newQueue;
		}
	}

	public static class SerialWriter implements Runnable {

		OutputStream out;

		public SerialWriter(OutputStream out) {
			this.out = out;
		}

		public void run() {
			try {
				int c = 0;
				while ((c = System.in.read()) > -1) {
					this.out.write(c);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public class Observer {
		String value = "";
	}

	public static void main(String[] args) {
		try {
			TwoWaySerialComm serial = new TwoWaySerialComm();
			serial.connect("/dev/ttyACM0");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}