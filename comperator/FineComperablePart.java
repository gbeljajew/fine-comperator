/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin.comperator;

/**
 *
 * @author gbeljajew
 */
public interface FineComperablePart 
{
    /**
     * 
     * 
     * @param fc
     * @return 0..100% how well it fits to fc 
     * @throws bin.comperator.IncompatibilityException if fc is of wrong Class or Enum
     */
    public int fineCompare(FineComperablePart fc) throws IncompatibilityException;
}
