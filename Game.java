import java.io.IOException;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class Game {
    public Game() throws IOException {
        this.terminalFactory = new DefaultTerminalFactory();
        this.terminal = terminalFactory.createTerminal();
        this.terminal.enterPrivateMode();
        this.terminal.setCursorVisible(true);
    }

    public DefaultTerminalFactory terminalFactory = null;
    public Terminal terminal = null;

    KeyType getBlockingInput() throws IOException {
        return this.terminal.readInput().getKeyType();
    }

    KeyStroke getNonBlockingInput() throws IOException {
        return this.terminal.pollInput();
    }
}