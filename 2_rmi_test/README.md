# RMI test

## Usage:
- Combine files and generate stub:
    ``` bash
    javac Client.java
    javac Server.java
    rmic ServerUpperImpl
    ```

- Run RMI server:
    ``` bash
    rmiregistry
    ```

- Run server:
    Open a new terminal window.  
    ``` bash
    java Server
    ```

- Run client:
    Open a new terminal window.  
    ``` bash
    java Client
    ```