package edu.cmu.deiis.annotators;


import org.apache.uima.jcas.cas.FSArray;

import edu.cmu.deiis.types.Answer;
import edu.cmu.deiis.types.NGram;
import edu.cmu.deiis.types.Question;
import edu.cmu.deiis.types.Sentence;

public class NGramOverlapAnswerScoreAnnotator extends AnswerScoreAnnotator{


  @Override
  public double calculateScore(Question question, Answer answer) {
    // TODO Auto-generated method stub
    double score = 0;
    Sentence questionSentence = question.getSentence();
    Sentence answerSentence = (Sentence) answer.getSentence();
    FSArray questionNgramArray = questionSentence.getNGramArray();
    FSArray answerNgramArray = answerSentence.getNGramArray();

    int overlapCount = 0;
    int totalWeight = 0;
    for (int i = 0; i < questionNgramArray.size(); i++) {
      boolean isFound = false;
      totalWeight = 0;
      for (int j = 0; j < answerNgramArray.size(); j++) {

        NGram questionToken = (NGram) questionNgramArray.get(i);
        NGram answerToken = (NGram) answerNgramArray.get(j);

        if (questionToken.getCoveredText().equals(answerToken.getCoveredText()) && !isFound) {
       
          //overlapCount++;
          overlapCount += answerToken.getElements().size();
          isFound = true;
          //break;
        }
        totalWeight += answerToken.getElements().size();
      }

    }
    //score = (float) overlapCount / (float) answerNgramArray.size();
    score = (float) overlapCount / (float) totalWeight;
    return score;
  }

  @Override
  public String getScoreMethodClass() {
    // TODO Auto-generated method stub
    return this.getClass().toString();
  }

}
