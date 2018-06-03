package junit.com;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** Test cases for the Pay Station system.
 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Department of Computer Science
     Aarhus University
   
   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/
public class TestIntegration {

  PayStation ps;

  @Before
  public void setUp() {
    ps = new PayStationImpl(new SenseBonificacio());
  }

  @Test
  public void Sensebonificacio() throws IllegalCoinException, NoEsPotBonificar {
    addOneDollar();
    assertEquals(100 / 5 * 2 , ps.buy().value() );
  }

  @Test
  public void CanviBonificacioMinuts() throws IllegalCoinException, NoEsPotBonificar {
    ps.canviarBonificacio(new BonificacioEnMinuts());
    addOneDollar();
    assertEquals(120 / 5 * 2, ps.buy().value());
  }

  @Test
  public void CanviSenseBonificacio() throws IllegalCoinException, NoEsPotBonificar {
    ps.canviarBonificacio(new SenseBonificacio());
    addOneDollar();
    assertEquals(100 / 5 * 2, ps.buy().value());
  }

  public void addOneDollar() throws IllegalCoinException {
    ps.addPayment(25);ps.addPayment(25);
    ps.addPayment(25);ps.addPayment(25);
  }

}
