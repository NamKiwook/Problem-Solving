public class A {
    static public void main(String[] args) {
        System.out.print(solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i <skill_trees.length; i++) {
            int[] position = new int[skill.length()];
            boolean isAble = true;
            for(int j = 0; j < skill.length(); j++) {
                char cur = skill.charAt(j);
                if(skill_trees[i].contains(""+cur)){
                    position[j] = skill_trees[i].indexOf(cur);
                } else {
                    position[j] = 100000;
                }
            }

            for(int j = 1; j < skill.length(); j++) {
                if(position[j - 1] > position[j]) {
                    isAble = false;
                    break;
                }
            }

            if(isAble) answer++;
        }

        return answer;
    }
}
