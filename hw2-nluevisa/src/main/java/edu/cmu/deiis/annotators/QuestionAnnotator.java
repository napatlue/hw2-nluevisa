package edu.cmu.deiis.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.analysis_engine.annotator.AnnotatorProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.deiis.types.Question;

public class QuestionAnnotator extends JCasAnnotator_ImplBase {
 
  private Pattern questionPattern = 
          Pattern.compile("Q [^\\n]*\\n");
  
  public QuestionAnnotator() {
    // TODO Auto-generated constructor stub
  }


  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
 // get document text
    String docText = aJCas.getDocumentText();
    System.out.println();
    // search for question pattern
    Matcher matcher = questionPattern.matcher(docText);
    int pos = 0;
    while (matcher.find(pos)) {
      // found one - create annotation
      Question annotation = new Question(aJCas);
      annotation.setBegin(matcher.start());
      annotation.setEnd(matcher.end());
      annotation.addToIndexes();
      pos = matcher.end();
    }
  }

}
