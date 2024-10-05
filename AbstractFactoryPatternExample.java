// abstract interface for button products
// different platforms will have different implementations
interface Button {
    void paint();
}

// abstract interface for window products
// same as button, window will have platform-specific versions
interface Window {
    void draw();
}

// concrete implementation of button for windows platform
class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("painting a button in Windows style");
    }
}

// concrete implementation of button for mac platform
class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("painting a button in Mac style");
    }
}

// concrete implementation of window for windows platform
class WindowsWindow implements Window {
    @Override
    public void draw() {
        System.out.println("drawing a window in Windows style");
    }
}

// concrete implementation of window for mac platform
class MacWindow implements Window {
    @Override
    public void draw() {
        System.out.println("drawing a window in Mac style");
    }
}

// abstract factory interface for creating platform-specific products
interface GUIFactory {
    Button createButton();  // method to create button
    Window createWindow();  // method to create window
}

// factory class for creating windows-style GUI components
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();  // creates a windows button
    }

    @Override
    public Window createWindow() {
        return new WindowsWindow();  // creates a windows window
    }
}

// factory class for creating mac-style GUI components
class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();  // creates a mac button
    }

    @Override
    public Window createWindow() {
        return new MacWindow();  // creates a mac window
    }
}

// client code demonstrating the abstract factory pattern
public class AbstractFactoryPatternExample {
    public static void main(String[] args) {
        // platform choice, for demo we'll choose Windows
        GUIFactory factory = new WindowsFactory();

        // create windows-style button and window
        Button button = factory.createButton();
        Window window = factory.createWindow();

        button.paint();  // paint the button in windows style
        window.draw();  // draw the window in windows style

        // now let's switch to Mac platform and create mac-style components
        factory = new MacFactory();
        Button macButton = factory.createButton();
        Window macWindow = factory.createWindow();

        macButton.paint();  // paint the button in mac style
        macWindow.draw();  // draw the window in mac style
    }
}
