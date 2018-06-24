import java.util.ArrayDeque;

public class BrianWorry {
    public String solution(String sentence) {
        try {
            String answer = "";

            ArrayDeque<Character> input = new ArrayDeque<>();
            int[] use = new int[26];
            for (int i = 0; i < sentence.length(); i++) {
                input.add(sentence.charAt(i));
                if (sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z') {
                    use[sentence.charAt(i) - 'a']++;
                }
            }

            while (!input.isEmpty()) {
                char firstInput = input.poll();
                ArrayDeque<Character> word = new ArrayDeque<>();

                if (firstInput >= 'a' && firstInput <= 'z') { //시작값이 소문자
                    if (use[firstInput - 'a'] != 2) return "invalid";
                    if (input.peek() >= 'a' && input.peek() <= 'z') return "invalid";
                    word.add(input.poll());
                    char thirdInput = input.poll();
                    if (thirdInput >= 'a' && thirdInput <= 'z' && thirdInput != firstInput) { //단어 안에 또 소문자가 있는 경우
                        for (int i = 1; i < use[thirdInput - 'a']; i++) {
                            if (input.peek() >= 'a' && input.peek() <= 'z') return "invalid";
                            word.add(input.poll());
                            if (input.poll() != thirdInput) return "invalid";
                        }
                        if (input.peek() >= 'a' && input.peek() <= 'z') return "invalid";
                        word.add(input.poll());
                        if (input.poll() != firstInput) return "invalid";
                    } else if (thirdInput != firstInput) { //앞뒤에만 있는 경우
                        word.add(thirdInput);
                        while (input.peek() != firstInput) {
                            if (input.peek() >= 'a' && input.peek() <= 'z') return "invalid";
                            word.add(input.poll());
                        }
                        input.poll();
                    }
                } else { //시작값이 대문자
                    word.add(firstInput);
                    if(input.isEmpty()) {
                        return answer + word.poll();
                    }
                    char secondInput = input.poll();
                    if (secondInput >= 'a' && secondInput <= 'z') {
                        if(use[secondInput - 'a'] == 2) {
                            input.addFirst(secondInput);
                        } else {
                            for (int i = 1; i < use[secondInput - 'a']; i++) {
                                if (input.peek() >= 'a' && input.peek() <= 'z') return "invalid";
                                word.add(input.poll());
                                if (input.poll() != secondInput) return "invalid";
                            }
                            if (input.peek() >= 'a' && input.peek() <= 'z') return "invalid";
                            word.add(input.poll());
                        }
                    } else {
                        word.add(secondInput);
                        if(input.isEmpty()) {
                            return answer + word.poll() + word.poll();
                        }
                        while (input.peek() >= 'A' && input.peek() <= 'Z') {
                            word.add(input.poll());
                            if(input.isEmpty())
                                break;
                        }
                        if(!input.isEmpty()) {
                            if (use[input.peek() - 'a'] != 2) {
                                input.addFirst(word.pollLast());
                            }
                        }
                    }
                }
                while (!word.isEmpty()) {
                    answer += word.poll();
                }
                if (!input.isEmpty())
                    answer += " ";
            }
            return answer;
        } catch(Exception e) {
            return "invalid";
        }
    }
}