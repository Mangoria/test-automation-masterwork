package masterwork.tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import masterwork.blogSitePages.BlogMainSite;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ExternalSave extends BaseTest{

  BlogMainSite objBlogMainSite;

  @Test
  @DisplayName("Opening PS test")
  public void dataListing() throws IOException {
    objBlogMainSite = new BlogMainSite(driver);
    objBlogMainSite.commentTitleList();
    String dataOutPut;
    FileWriter writeFile = new FileWriter("src/test/resources/output.txt");
    for (int i = 0; i < objBlogMainSite.commentTitleList().size(); i++) {
      if (i>0){
        writeFile.append("\n");
      }
      dataOutPut = (objBlogMainSite.commentTitleList().get(i).getText());
        writeFile.append(dataOutPut);
    }
    writeFile.close();
    BufferedReader input = new BufferedReader(new FileReader("src/test/resources/output.txt"));
    String last = "", line;

    while ((line = input.readLine()) != null) {
      last = line;
    }
    assertThat(last).isEqualTo(objBlogMainSite.commentTitle(9));
    }
  }



