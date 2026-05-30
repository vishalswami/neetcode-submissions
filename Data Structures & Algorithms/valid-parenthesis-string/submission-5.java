class Solution {
    private static final char LEFT_PARA = '(';
    private static final char RIGHT_PARA = ')';
    private static final char WILD = '*';
    public boolean checkValidString(String s) {
        if(s.isEmpty()) {
            return false;
        }
        var stack = new ArrayDeque<Integer>();
        var wildStack = new ArrayDeque<Integer>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == LEFT_PARA) {
                stack.push(i);
            } else if(c == RIGHT_PARA) {
                if(stack.isEmpty()) {
                    if(wildStack.isEmpty()) {
                        return false;
                    } else {
                        wildStack.pop();
                    }
                } else {
                    stack.pop();
                }
            } else {
                wildStack.push(i);
            }
        }

        while(!stack.isEmpty()) {
            if(wildStack.isEmpty() || (stack.pop() > wildStack.pop())) {
                return false;
            }
        }
        return true;
    }
}
