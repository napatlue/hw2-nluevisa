

/* First created by JCasGen Mon Oct 07 00:44:58 EDT 2013 */
package org.cleartk.util.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.cleartk.score.type.ScoredAnnotation;


/** 
 * Updated by JCasGen Mon Oct 07 02:32:29 EDT 2013
 * XML source: /Users/napatluevisadpaibul/git/hw2-nluevisa/hw2-nluevisa/src/main/resources/hw3-nluevisa-aae.xml
 * @generated */
public class Parenthetical extends ScoredAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Parenthetical.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Parenthetical() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Parenthetical(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Parenthetical(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Parenthetical(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
}

    