package edu.cmu.deiis.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.analysis_engine.annotator.AnnotatorProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.deiis.types.Answer;
/** This class annotated all the answer in document */
public class AnswerAnnotator extends JCasAnnotator_ImplBase {
 
  private Pattern answerPattern = 
          Pattern.compile("A \\d [^\\n]*\\n");
  
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    // get document text
    String docText = aJCas.getDocumentText();
    // search for answer pattern
    Matcher matcher = answerPattern.matcher(docText);
    int pos = 0;
    while (matcher.find(pos)) {
      // found one - create annotation
      Answer annotation = new Answer(aJCas);
      String str = docText.substring(matcher.start()+2, matcher.start()+3);
      boolean isCorrect;
      if(str.compareTo("1") == 0)
      {
        isCorrect = true;
      }
      else
      {
        isCorrect = false;
      }
      annotation.setConfidence(1.0);
      annotation.setCasProcessorId(this.getClass().getName());
      annotation.setIsCorrect(isCorrect);
      annotation.setBegin(matcher.start());
      annotation.setEnd(matcher.end());
      //System.out.println(isCorrect);
      annotation.addToIndexes();
      pos = matcher.end();
    }
  }

}
