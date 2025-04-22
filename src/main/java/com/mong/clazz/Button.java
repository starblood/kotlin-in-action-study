package com.mong.clazz;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/* Java */
public class Button implements View {
    @Override
    public State getCurrentState() {
        return new ButtonState();
    }

    @Override
    public void restoreState(State state) { /*...*/ }

    public class ButtonState implements State { /*...*/
    }

    public static void main(String[] args) throws Exception {
        Button button = new Button();

        State state = button.getCurrentState();

        FileOutputStream fileOut = new FileOutputStream("person.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(state);  // 🔥 serialize 수행, Error 발생, 해결하기 위해서는 Kotlin code 에서 Outer modifier 가 필요
        out.close();
        fileOut.close();

        System.out.println("Serialized data is saved in person.ser");
    }
}
