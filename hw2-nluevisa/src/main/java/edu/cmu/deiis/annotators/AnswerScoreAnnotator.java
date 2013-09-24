package edu.cmu.deiis.annotators;



import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import edu.cmu.deiis.types.Answer;
import edu.cmu.deiis.types.AnswerScore;
import edu.cmu.deiis.types.Question;
/** This is an abstract class annotated the answer with score with all the method defined in our pipeline 
 * */
public abstract class AnswerScoreAnnotator extends JCasAnnotator_ImplBase {

  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    // get document text
    String docText = aJCas.getDocumentText();
    FSIndex QuestionIndex = aJCas.getAnnotationIndex(Question.type);
    Iterator QuestionIter = QuestionIndex.iterator();
    while (QuestionIter.hasNext()) {
      Question question = (Question) QuestionIter.next();
      FSIndex AnswerIndex = aJCas.getAnnotationIndex(Answer.type);
      Iterator AnswerIter = AnswerIndex.iterator();
      while (AnswerIter.hasNext()) {
        Answer answer = (Answer) AnswerIter.next();
        AnswerScore annotation = new AnswerScore(aJCas);
        annotation.setBegin(answer.getBegin());
        annotation.setEnd(answer.getEnd());
        annotation.setAnswer(answer);
        /*
        if (answer.getIsCorrect()) {
          annotation.setGoldStandard(1);
        } else {
          annotation.setGoldStandard(0);
        }
        */
        double score = calculateScore(question, answer);
        
        //annotation.setScore(getNGramOverlap(question, answer));
        annotation.setScore(score);
        annotation.setConfidence(1.0f);
        annotation.setCasProcessorId(this.getClass().toString());
        annotation.addToIndexes();
      }
    }

  }
  
  /** calculateScore(Question question, Answer answer) is an abstract method to calculate score of answer to the question
   * 
   * @param question     Question that we want to answer
   * @param answer       Answer that we will compute the score
   * @return      Score of the answer
   */
  public abstract double calculateScore(Question question, Answer answer);
  


}
