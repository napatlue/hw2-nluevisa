package edu.cmu.deiis.annotators;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;

import edu.cmu.deiis.types.Answer;
import edu.cmu.deiis.types.Question;
import edu.cmu.deiis.types.Sentence;
import edu.cmu.deiis.types.Token;
/** This is a concrete class inherited from AnswerScoreAnnotator. It 
 * annotated the answer with score computed by NGramOverlap method 
 * */
public class TokenOverlapAnswerScoreAnnotator extends AnswerScoreAnnotator{

  public TokenOverlapAnswerScoreAnnotator() {
    // TODO Auto-generated constructor stub
  }

  /** calculate score using Token Overlap Method 
   *  @Override
   **/
  public double calculateScore(Question question, Answer answer, JCas aJCas) {
    // TODO Auto-generated method stub
    double score = 0;
    Sentence questionSentence = question.getSentence();
    Sentence answerSentence = (Sentence) answer.getSentence();
    FSArray questionTokenArray = questionSentence.getTokenArray();
    FSArray answerTokenArray = answerSentence.getTokenArray();
    
    int overlapCount = 0;
    for (int i = 0; i < questionTokenArray.size(); i++) {
      for (int j = 0; j < answerTokenArray.size(); j++) {

        Token questionToken = (Token) questionTokenArray.get(i);
        Token answerToken = (Token) answerTokenArray.get(j);

        if (questionToken.getCoveredText().equals(answerToken.getCoveredText())) {
          overlapCount++;
          break;
        }
      }
    
    }
    score = (float) overlapCount / (float) answerTokenArray.size();

    return score;
  }


}
