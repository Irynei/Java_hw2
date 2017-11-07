package mail_sender_2;


import javassist.Modifier;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MailSender2 {

    private Map<Integer, MailGenerator> map = new HashMap<>();

    public MailSender2() throws IllegalAccessException, InstantiationException {
        Reflections scanner = new Reflections("mail_sender_2");
        Set<Class<? extends MailGenerator>> classes = scanner.getSubTypesOf(MailGenerator.class);
        for (Class<? extends MailGenerator> aClass : classes) {
            if(!Modifier.isAbstract(aClass.getModifiers())) {
                int mailCode = aClass.getAnnotation(MailCode.class).value();
                map.put(mailCode, aClass.newInstance());
            }
        }

    }

    public void sendMail(MailInfo mailInfo) {

        MailGenerator mailGenerator = map.get(mailInfo.getMailCode());
        if (mailGenerator == null) {
            throw new IllegalStateException(mailInfo.getMailCode() + " not supported yet");
        }
        String html = mailGenerator.generateHtml(mailInfo);
        send(html,mailInfo);


    }

    private void send(String html, MailInfo mailInfo) {
        System.out.println("sending to ... " + html);
    }


}
