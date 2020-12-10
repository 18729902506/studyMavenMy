package example.springtest.antpathmatchertest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.AntPathMatcher;

public class AntPathMatcherTest {

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Test
    public void test(){
        pathMatcher.setCachePatterns(true);
        pathMatcher.setCaseSensitive(true);
        pathMatcher.setPathSeparator("/");
        pathMatcher.setTrimTokens(true);

        Assert.assertTrue(pathMatcher.match("a", "a"));
        Assert.assertTrue(pathMatcher.match("a*", "ab"));
        Assert.assertTrue(pathMatcher.match("a*/**/a", "ab/asdsa/a"));
        Assert.assertTrue(pathMatcher.match("a*/**/a", "ab/asdsa/asdasd/a"));


        Assert.assertTrue(pathMatcher.match("*", "a"));
        Assert.assertTrue(pathMatcher.match("*/*", "a/a"));
    }
}
