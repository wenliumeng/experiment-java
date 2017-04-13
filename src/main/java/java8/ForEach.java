package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 采用java8中的新流式特性来替代foreach循环
 * 遍历查询
 * Created by seymour on 17/4/10.
 */
public class ForEach {
    private class Article {

        private final String title;
        private final String author;
        private final List<String> tags;

        private Article(String title, String author, List<String> tags) {
            this.title = title;
            this.author = author;
            this.tags = tags;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public List<String> getTags() {
            return tags;
        }
    }

    public Article getFirstJavaArticle1(List<Article> articles) {

        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                return article;
            }
        }
        return null;
    }

    public Optional<Article> getFirstJavaArticle2(List<Article> articles) {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst();
    }

    /**
     * 寻找容器中的元素
     * stream延迟计算
     */
    public void example1(){
        List<Article> articles = new ArrayList<>();
        Article article1 = new Article("title1","zhangsan", Arrays.asList("tag1","tag2"));
        Article article2 = new Article("title2","lisi", Arrays.asList("Java","tag4"));
        Article article3 = new Article("title3","wangwu", Arrays.asList("tag5","tag6"));
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);

        ForEach forEach = new ForEach();
        System.out.println(forEach.getFirstJavaArticle1(articles).getAuthor());
        System.out.println("--------");
        System.out.println(forEach.getFirstJavaArticle2(articles).get().getAuthor());
    }

    public List<Article> getAllJavaArticle1(List<Article> articles){
        ArrayList<Article> result = new ArrayList<>();
        for (Article article : articles){
            if (article.getTags().contains("Java"))
                result.add(article);
        }
    }

    public List<Article> getAllJavaArticle2(List<Article> articles){
        //数组
        //Long count = Arrays.stream(source).filter(source1 -> source1.equals(substring)).count();
        return articles.stream().filter(article -> article.getTags().contains("Java")).collect(Collectors.toList());
    }

    public void example2(){

    }
    public static void main(String[] args) {
        ForEach forEach = new ForEach();
        forEach.example1();
    }
}


