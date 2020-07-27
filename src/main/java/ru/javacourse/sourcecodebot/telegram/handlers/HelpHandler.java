package ru.javacourse.sourcecodebot.telegram.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.javacourse.sourcecodebot.telegram.MessageHandler;

import java.io.*;

public class HelpHandler implements MessageHandler {

    @Override
    public SendMessage handle(Update update) {
        SendMessage msg = new SendMessage();

        msg.enableMarkdown(true);
        msg.setChatId(update.getMessage().getChatId());
        //msg.setText("Документация находится в разработке");
        msg.setText(getHelpDescription());
        return msg;
    }

    private String getHelpDescription(){
        String path = "./help/description-help.txt";
        String s = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while (reader.ready()){
                s=s+reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
