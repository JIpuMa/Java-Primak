package com.company.Cw;

public class t_04_04_00 {
    public void main() {
        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.getConnection());
    }
}

class ConnectionManager {
    private static int cur_conn = 0;
    private static int num_conns = 2;
    private static Connection[] connections = new Connection[]{
            new Connection("url1"),
            new Connection("url2"),
            new Connection("url3")
    };

    public ConnectionManager() {}

    public static Connection getConnection() {
        if (cur_conn < num_conns) {
            Connection conn = connections[cur_conn];
            cur_conn++;
            return conn;
        }
        return null;
    }
}

class Connection {
    private String url;

    public Connection() {}

    public Connection(String url) {
        setConnection(url);
    }

    public void setConnection(String url) {
        this.url = url;
    }

    public Connection getConnection() {
        return this;
    }

    public String toString() {
        return "Url: " + url;
    }
}
