package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.utilities;

import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.frames.DataBaseConfiguration;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ConnectionClass {

	private static Properties Info = null;

	public ConnectionClass() {
		Check(KeyWords._Properties);
	}
	public static void PopulatePropertiesFromFile() {
		try {
			Scanner fileScanner = new Scanner(new File(KeyWords._DBConf));
			while (fileScanner.hasNext()) {
				String Line = fileScanner.next();
				String Key = Line.split("=")[0], Value = Line.split("=")[1];
				setProp(Key, Value);
			}
			fileScanner.close();
		} catch (FileNotFoundException e1) {
			System.out.println("File Access Problem!");
		}
	}

	public static void initProperties() {
		PopulatePropertiesFromFile();
		setProp(KeyWords._Driver, new oracle.jdbc.driver.OracleDriver());
		setProp(KeyWords._D_S_, KeyWords._None);
		setProp(KeyWords._Url, "jdbc:oracle:" + getProp(KeyWords._DriverType)
				+ ":@" + getProp(KeyWords._Host) + ":"
				+ getProp(KeyWords._Port) + ":" + getProp(KeyWords._DBName));
		setProp(KeyWords._C_S_, KeyWords._None);
		setProp(KeyWords._F_S_, KeyWords._Success);
		Check(KeyWords._Driver);
		Check(KeyWords._Connection);
		/*if (getProp(KeyWords._F_S_).toString().equals(KeyWords._Success)) {
			System.out.println("Initialisation Successful :)");
		} else {
			System.out.println("Something went wrong :(");
		}*/
	}

	public static void rePopulate() {
		Info = null;
		Check(KeyWords._Properties);
	}

	public static void Check(Object Key) {
		if (Key.equals(KeyWords._Properties)) {
			if (Info == null) {
				Info = new Properties();
				Path path = Paths.get(KeyWords._DBConf);
				if (Files.exists(path)) {
					initProperties();
				} else {
					JFrame DBC = new DataBaseConfiguration();
					DBC.setVisible(true);
					DBC.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					DBC.addWindowListener(new WindowListener() {

						@Override
						public void windowOpened(WindowEvent arg0) {
							// TODO Auto-generated method stub

						}

						@Override
						public void windowIconified(WindowEvent arg0) {
							// TODO Auto-generated method stub

						}

						@Override
						public void windowDeiconified(WindowEvent arg0) {
							// TODO Auto-generated method stub

						}

						@Override
						public void windowDeactivated(WindowEvent arg0) {
							// TODO Auto-generated method stub

						}

						@Override
						public void windowClosing(WindowEvent arg0) {

						}

						@Override
						public void windowClosed(WindowEvent arg0) {
							initProperties();
							setProp(KeyWords._DonePopulating, "true");
						}

						@Override
						public void windowActivated(WindowEvent arg0) {
							// TODO Auto-generated method stub

						}
					});
					while (DBC.isEnabled()) {
						if (getProp(KeyWords._DonePopulating) != null)
							break;
					}
				}
			} else {
				Check(KeyWords._Driver);
				Check(KeyWords._Connection);
			}
		} else if (Key.equals(KeyWords._Driver)) {
			if (!getProp(KeyWords._D_S_).equals(KeyWords._Success)) {
				try {
					DriverManager
							.registerDriver((Driver) getProp(KeyWords._Driver));
					setProp(KeyWords._D_S_, KeyWords._Success);
					// System.out.println("Driver Registred :)");
				} catch (Exception ex) {
					// System.out.println("Driver State = " + ex.getMessage());
					setProp(KeyWords._D_S_, ex.getMessage());
					setProp(KeyWords._F_S_, KeyWords._None);
				}
			}
		} else if (Key.equals(KeyWords._Connection)) {
			if (!getProp(KeyWords._C_S_).equals(KeyWords._Success)||((Connection) getProp(KeyWords._Connection))==null) {
				try {
					setProp(KeyWords._Connection, DriverManager.getConnection(
							getProp(KeyWords._Url).toString(),
							getProp(KeyWords._User).toString(),
							getProp(KeyWords._Pass).toString()));
					setProp(KeyWords._C_S_, KeyWords._Success);
					((Connection) getProp(KeyWords._Connection))
							.setAutoCommit(false);
					// System.out.println("Connected To Database :)");
				} catch (Exception ex) {
					// System.out.println("Connection State = " +
					// ex.getMessage());
					setProp(KeyWords._C_S_, ex.getMessage());
					setProp(KeyWords._F_S_, KeyWords._None);
				}
			}
		}
	}

	public static Object getStatus(Object Key) {
		if (Key.toString().equals(KeyWords._Check)) {
			if (Info == null) {
				return KeyWords._None;
			} else {
				if (!getProp(KeyWords._F_S_).toString().equals(
						KeyWords._Success)) {
					return KeyWords._None;
				}
			}
			// System.out.println("Success");
			return KeyWords._Success;
		} else if (Key.toString().equals(KeyWords._Get)) {
			Properties err = new Properties();
			if (Info == null) {
				err.put(KeyWords._Initialisation, KeyWords._None);
			} else {
				err.put(KeyWords._Initialisation, KeyWords._Success);
				err.put(KeyWords._ConnectionType,
						getProp(KeyWords._ConnectionType));
				err.put(KeyWords._D_S_, getProp(KeyWords._D_S_));
				err.put(KeyWords._C_S_, getProp(KeyWords._C_S_));
				err.put(KeyWords._F_S_, getProp(KeyWords._F_S_));
			}
			return err;
		} else {
			return null;
		}
	}

	public static void setProp(Object Key, Object Value) {
		Info.put(Key, Value);
	}

	public static Object getProp(Object Key) {
		return Info.get(Key);
	}

	public static Connection getConnection() {
		Check(KeyWords._Connection);
		setProp(KeyWords._F_S_, KeyWords._Success);
		return ((Connection) getProp(KeyWords._Connection));
	}

	public static void closeConnection() {
		try {
			((Connection) getProp(KeyWords._Connection)).close();
			setProp(KeyWords._C_S_, KeyWords._Closed);
			setProp(KeyWords._F_S_, KeyWords._None);
		} catch (Exception ex) {
			setProp(KeyWords._C_S_, ex.getMessage());
			setProp(KeyWords._F_S_, KeyWords._None);
		}
	}
}