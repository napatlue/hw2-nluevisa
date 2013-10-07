package edu.cmu.deiis.annotators;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.cleartk.ne.type.NamedEntityMention;

import edu.cmu.deiis.types.Answer;
import edu.cmu.deiis.types.AnswerScore;
import edu.cmu.deiis.types.Question;

/**
 * NamedEntityScoreAnnotator scores result based on the % of overlapping of
 * NamedEntityMentions
 * 
 */
public class NameEntityAnswerScoreAnnotator extends  AnswerScoreAnnotator {

  

  @Override
  public double  calculateScore(Question q, Answer ans, JCas aJCas) {
    AnnotationIndex<Annotation> namedEntities = aJCas.getAnnotationIndex(NamedEntityMention.type);

    Set<String> qNE = getTokensForAnnotationSpan(q, namedEntities);

    Set<String> aNE = getTokensForAnnotationSpan(ans, namedEntities);

    double numANE = aNE.size();

    // find union of name entity
    aNE.retainAll(qNE);
    double numOverlapNEs = aNE.size();

    // divide the size of union by the size of answer.
    return (numOverlapNEs / numANE);
    
  }

  /**
   * Get all NamedEntityMentions for an annotation span as a String set.
   * 
   * @param annotation
   *          Input Annotation span
   * @param tokens
   *          AnnotationIndex for the tokens
   * @return Set of token String
   */
  private Set<String> getTokensForAnnotationSpan(Annotation annotation,
          AnnotationIndex<Annotation> namedEntities) {
    Set<String> NESet = new HashSet<String>();
    Iterator<Annotation> neIterator = namedEntities.subiterator(annotation);

    while (neIterator.hasNext()) {
      NamedEntityMention ne = (NamedEntityMention) neIterator.next();
      NESet.add(ne.getCoveredText());
    }
    return NESet;
  }

}
