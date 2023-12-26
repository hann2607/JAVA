package demo.javaio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DemoJavaio {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		// Get absolutePath
		Path resourceDirectory = Paths.get("src", "main", "resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		
		// Demo FileInputStream
		demoFileInputStream(absolutePath);
		
		// Demo FileOutputStream
		demoFileOutputStream(absolutePath);
		
		// Demo BufferedInputStream
		demoBufferedInputStream(absolutePath);
		
		// Demo BufferedOuputStream
		demoBufferedOutputStream(absolutePath);
	}
	
	@SuppressWarnings("resource")
	private static void demoFileInputStream(String absolutePath) throws IOException {
		int i = 0;
		int bytesRead = 0;       // Read data from FileChannel to ByteBuffer
		long skipped = 0;       // Quantity character skipped
		long start = 0;       // check time for read FileInputStream
		long end = 0;       // check time for read FileInputStream
		FileInputStream fin = null;
		FileDescriptor fileDescriptor = null;
		FileChannel fileChannel = null;
		ByteBuffer buffer = null;
		File file = null;
		
		try {
			// Demo FileInputStream
			file = new File(absolutePath + "\\file\\demo.txt");
			if(file.exists()) {
				fin = new FileInputStream(file);

				// Demo available()
				System.out.println("Demo available(): " + fin.available());

				// Read one character
				i = fin.read();
				System.out.println("\nDemo read one character: " + (char) i);

				// Read All file
				fin = new FileInputStream(absolutePath + "\\file\\demo.txt"); // reset FileInputStream
				start = System.nanoTime();
				System.out.print("\nDemo read All File: ");
				while ((i = fin.read()) != -1) {
					System.out.print((char) i);
				}
				end = System.nanoTime();
				System.out.println("\n\nTime for read by FileInputStream: " + (end - start));

				// Demo skip character
				fin = new FileInputStream(absolutePath + "\\file\\demo.txt"); // reset FileInputStream
				skipped = fin.skip(10);
				System.out.print("\nquantity character skipped: " + skipped + "--> ");
				while ((i = fin.read()) != -1) {
					System.out.print((char) i);
				}

				// Demo FileDescriptor
				fileDescriptor = fin.getFD();
				System.out.println("\n\nCheck valid of FileDescriptor before read file by FileInputStream: " 
				+ fileDescriptor.valid());

				// Demo FileChannel
				fileChannel = fin.getChannel(); // Get Channel from FileInputStream
				fileChannel.position((long) 11); // Read position = 10 --> end
				buffer = ByteBuffer.allocate(1024); // Create new ByteBuffer
				bytesRead = fileChannel.read(buffer); // Read data from FileChannel to ByteBuffer

				// Change mode write --> read ByteBuffer
				buffer.flip();

				// Read buffer
				System.out.print("\nDemo read FileChannel at position 10 --> end: ");
				if(bytesRead != -1) {
					while (buffer.hasRemaining()) {
						// Read byte from buffer
						byte currentByte = buffer.get();
						System.out.print((char) currentByte);
					}
				}
				
				// Clear buffer and close FileChannel
				buffer.clear();
				fileChannel.close();
			} else {
				System.out.println("File demo.txt didn't exits!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fin != null) {
				fin.close();
			}
		}
	}
	
	private static void demoFileOutputStream(String absolutePath) throws IOException {
		FileOutputStream fou = null;
		
		try {
			fou = new FileOutputStream(new File(absolutePath + "\\file\\demo.txt"));
			
			// Write file use FileOutputStream
			String data = "test write file use FileOutputStream";
			byte[] arrByteData = data.getBytes();
			fou.write(arrByteData);
			fou.flush();
			fou.close();
			
			System.out.println("\n\n======================================================");
			System.out.println("Demo write file use FileOutputStream successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fou.close();
		}
	}
	
	private static void demoBufferedInputStream(String absolutePath) {
		FileInputStream fin = null;
		BufferedInputStream bufferedInputStream = null;
		long start = 0;       // check time for read FileInputStream
		long end = 0;       // check time for read FileInputStream
		int i = 0;
		File file = null;
		
		System.out.println("======================================================");
		try {
			file = new File(absolutePath + "\\file\\demoBuffered.txt");
			if(file.exists()) {
				fin = new FileInputStream(file);
				start = System.nanoTime();
				bufferedInputStream = new BufferedInputStream(fin);
				System.out.print("\nDemo read file BufferedInputStream: ");
				while ((i = bufferedInputStream.read()) != -1) {
					System.out.print((char) i);
				}
				end = System.nanoTime();
				System.out.println("\n\nTime for read by BufferedInputStream: " + (end - start));	
			} else {
				System.out.print("\nFile demoBuffered.txt didn't exits!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void demoBufferedOutputStream(String absolutePath) throws IOException {
		FileOutputStream fou = null;
		BufferedOutputStream bufferedOutputStream = null;
		
		try {
			fou = new FileOutputStream(new File(absolutePath + "\\file\\demoBuffered.txt"));
			bufferedOutputStream = new BufferedOutputStream(fou);
			
			// Write file use BufferedOutputStream
			String data = "test write file use BufferedOutputStream";
			byte[] arrByteData = data.getBytes();
			bufferedOutputStream.write(arrByteData);
			bufferedOutputStream.flush(); 
			bufferedOutputStream.close();
			
			System.out.println("\n\n======================================================");
			System.out.println("Demo write file use BufferedOutputStream successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fou.close();
		}
	}
}
