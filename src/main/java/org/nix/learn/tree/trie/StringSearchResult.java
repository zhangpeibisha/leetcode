package org.nix.learn.tree.trie;

/**
 * @author zhangpei
 * @version 1.0
 * @description
 * @date 2019/2/21
 */
public class StringSearchResult {

    int index;

    private String keyword;

    public StringSearchResult(int i, String result) {
        this.index = i;
        this.keyword = result;
    }

    public String keyword() {
        return keyword;
    }

    public int index() {
        return index;
    }
}
