import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SimpleConnectionPool {
    private final String url = "jdbc:mysql://localhost:3306/yourdb";
    private final String user = "yourusername";
    private final String password = "yourpassword";

    private final int poolSize = 5;
    private final BlockingQueue<Connection> connectionPool;

    public SimpleConnectionPool() throws SQLException {
	connectionPool = new ArrayBlockingQueue<>(poolSize);
	initializeConnectionPool();
    }

    private void initializeConnectionPool() throws SQLException {
	for (int i = 0; i < poolSize; i++) {
	    connectionPool.offer(createNewConnection());
	}
    }

    private Connection createNewConnection() throws SQLException {
	return DriverManager.getConnection(url, user, password);
    }

    public Connection getConnection() throws InterruptedException {
	return connectionPool.take(); // waits if necessary
    }

    public void releaseConnection(Connection connection) {
	if (connection != null) {
	    connectionPool.offer(connection);
	}
    }

    public void shutdown() throws SQLException {
	for (Connection conn : connectionPool) {
	    conn.close();
	}
    }

    public static void main(String[] args) {
	try {
	    SimpleConnectionPool pool = new SimpleConnectionPool();

	    Connection conn = pool.getConnection();
	    System.out.println("Got a connection!");

	    // Use the connection here...
	    // e.g., PreparedStatement, ResultSet, etc.

	    pool.releaseConnection(conn);
	    System.out.println("Returned the connection!");

	    pool.shutdown(); // Optional: on app shutdown

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
