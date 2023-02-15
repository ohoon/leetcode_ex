/*
2424.
Longest Uploaded Prefix
https://leetcode.com/problems/longest-uploaded-prefix/
*/

class LUPrefix {
    boolean[] stream;
    int len;
    
    public LUPrefix(int n) {
        stream = new boolean[n];
        len = 0;
    }
    
    public void upload(int video) {
        stream[video-1] = true;
    }
    
    public int longest() {
        for (int i = len; i <= stream.length; i++) {
            if (i == stream.length || !stream[i]) {
                len = i;
                break;
            }
        }

        return len;
    }
}
