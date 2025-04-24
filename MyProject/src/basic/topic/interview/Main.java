package basic.topic.interview;
// "static void main" must be defined in a public class.
public class Main {

  static String solution(String[] rooms) {
    Map<String, Integer> m = new HashMap<String, Integer>();
    for (int i = 0; i < rooms.length; ++i) {
        if (rooms[i].charAt(0) == '+') {
            m.put(rooms[i].substring(1,3), m.getOrDefault(rooms[i].substring(1,3), 0)+1);
        }
    }
    int max = 0;
    String key = "";
    for (String next : m.keySet()) {
        if (max<m.get(next)) {
            key = next;
            max = m.get(next);
        }
    }
    return key;
  }

  public static void main(String[] args) {
    String[] rooms = {"+1A", "+3E", "-1A", "+4F", "+1A", "-3E"};
    System.out.print(solution(rooms));
  }
}