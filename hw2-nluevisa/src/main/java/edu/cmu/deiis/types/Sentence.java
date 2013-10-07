

/* First created by JCasGen Mon Sep 23 01:29:20 EDT 2013 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;


/** The sentence in the system
 * Updated by JCasGen Mon Oct 07 00:44:50 EDT 2013
 * XML source: /Users/napatluevisadpaibul/git/hw2-nluevisa/hw2-nluevisa/src/main/resources/hw3-nluevisa-aae.xml
 * @generated */
public class Sentence extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Sentence.class);
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
  protected Sentence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Sentence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Sentence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Sentence(JCas jcas, int begin, int end) {
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
     
 
    
  //*--------------*
  //* Feature: tokenArray

  /** getter for tokenArray - gets The array of token in the sentence
   * @generated */
  public FSArray getTokenArray() {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_tokenArray == null)
      jcasType.jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_tokenArray)));}
    
  /** setter for tokenArray - sets The array of token in the sentence 
   * @generated */
  public void setTokenArray(FSArray v) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_tokenArray == null)
      jcasType.jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    jcasType.ll_cas.ll_setRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_tokenArray, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for tokenArray - gets an indexed value - 
   * @generated */
  public Token getTokenArray(int i) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_tokenArray == null)
      jcasType.jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_tokenArray), i);
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_tokenArray), i)));}

  /** indexed setter for tokenArray - sets an indexed value - 
   * @generated */
  public void setTokenArray(int i, Token v) { 
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_tokenArray == null)
      jcasType.jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_tokenArray), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_tokenArray), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: NGramArray

  /** getter for NGramArray - gets NGram generated from the sentence
   * @generated */
  public FSArray getNGramArray() {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_NGramArray == null)
      jcasType.jcas.throwFeatMissing("NGramArray", "edu.cmu.deiis.types.Sentence");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_NGramArray)));}
    
  /** setter for NGramArray - sets NGram generated from the sentence 
   * @generated */
  public void setNGramArray(FSArray v) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_NGramArray == null)
      jcasType.jcas.throwFeatMissing("NGramArray", "edu.cmu.deiis.types.Sentence");
    jcasType.ll_cas.ll_setRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_NGramArray, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for NGramArray - gets an indexed value - 
   * @generated */
  public NGram getNGramArray(int i) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_NGramArray == null)
      jcasType.jcas.throwFeatMissing("NGramArray", "edu.cmu.deiis.types.Sentence");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_NGramArray), i);
    return (NGram)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_NGramArray), i)));}

  /** indexed setter for NGramArray - sets an indexed value - 
   * @generated */
  public void setNGramArray(int i, NGram v) { 
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_NGramArray == null)
      jcasType.jcas.throwFeatMissing("NGramArray", "edu.cmu.deiis.types.Sentence");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_NGramArray), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_NGramArray), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    