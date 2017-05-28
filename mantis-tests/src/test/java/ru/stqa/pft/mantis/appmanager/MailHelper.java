package ru.stqa.pft.mantis.appmanager;

import org.eclipse.jetty.util.IO;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alesia on 28.05.17.
 */
public class MailHelper {
  private ApplicationManager app;
  private final Wiser wiser;

  public MailHelper (ApplicationManager app){
    this.app=app;
    wiser = new Wiser();
  }

  public List <MailMessage> waitForMail (int count, long timeout) throws MessagingException, IOException {
    long start = System.currentTimeMillis();
    while (System.currentTimeMillis() < start + timeout){
      if (wiser.getMessages().size() >= count){
        return wiser.getMessages().stream().map((m)-> toModelMail(m)).collect(Collectors.toList());
      }
      try {
        Thread.sleep(1000);
      }
      catch (InterruptedException e){
        e.printStackTrace();
      }
    }
    throw new Error("No mail :(");
  }

  public static MailMessage toModelMail(WiserMessage m)  {
    try {
      MineMessage mm = m.getMimeMessage();
      return new MailMessage (mm.getAllRecepients[0].toString(), (String) mm.getContent());
    } catch (MessagingException e){
      e.printStackTrace();
      return null;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }


 public void start (){
    wiser.start();
 }
 public void stop (){
   wiser.stop();
 }
}
