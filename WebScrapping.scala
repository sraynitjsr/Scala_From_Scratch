import org.jsoup.Jsoup
object WebScraper {
  def main(args: Array[String]): Unit = {
    val url = "https://example.com"    
    val doc = Jsoup.connect(url).get()
    val links = doc.select("a[href]")
    links.forEach(link => {
      val title = link.text()
      val linkUrl = link.attr("href")
      println(s"Title: $title, URL: $linkUrl")
    })
  }
}
