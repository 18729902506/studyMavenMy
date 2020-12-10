package example.serialtest.test1;

public class Producer {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("混世魔王");
        //序列化，保存到磁盘上
//        SerializationUtils.writeObject(person);
    }
}
