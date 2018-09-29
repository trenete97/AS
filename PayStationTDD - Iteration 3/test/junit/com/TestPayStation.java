package junit.com;

import org.junit.*;
import static org.junit.Assert.*;

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
public class TestPayStation {
  PayStation ps;
  /** Fixture for pay station testing. */
  @Before
  public void setUp() {
    ps = new PayStationImpl();
  }

  /**
   * Entering 5 cents should make the display report 2 minutes 
   * parking time.
  */
  @Test
  public void shouldDisplay2MinFor5Cents() throws IllegalCoinException {
    ps.addPayment( 5 );
    assertEquals( "Should display 2 min for 5 cents", 
                  2, ps.readDisplay() ); 
  }

  /**
   * Entering 25 cents should make the display report 10 minutes
   * parking time.
  */
  @Test
  public void shouldDisplay10MinFor25Cents() throws IllegalCoinException {
    ps.addPayment( 25 );
    assertEquals( "Should display 10 min for 25 cents", 
                  25 / 5 * 2, ps.readDisplay() );
    // 25 cent in 5 cent coins each giving 2 minutes parking
  }

  /** 
   * Verify that illegal coin values are rejected.
  */
  @Test(expected=IllegalCoinException.class)
  public void shouldRejectIllegalCoin() throws IllegalCoinException {
    ps.addPayment(17);
  }
  /** 
   * Escollim el test “enter 10 and 25 coins” per completar la funcionalitat que valida les monedes introduïdes
  */
  @Test
  public void enter10and25coins() throws IllegalCoinException {
    ps.addPayment(10);
    ps.addPayment(25);
    assertEquals( "Should display 14 min for 35 cents", 
            35 / 5 * 2, ps.readDisplay() );
  }


  /** 
   * Escollim el test “receipt can store values”
   */
  @Test
  public void receiptCanStoreValues() throws IllegalCoinException {
	  ps.addPayment(5);
	  ps.addPayment(10);
	  ps.addPayment(25);
	  Receipt r = ps.buy();
	  assertEquals( "Should display 14 min for 35 cents", 
			  40 / 5 * 2, r.value() );
  }
  
  /** 
   * Escollim el test “buy produces valid receipt”
   */
  @Test
  public void buyProducesValidReceipt() throws IllegalCoinException {
	  ps.addPayment(5);
	  ps.addPayment(10);
	  ps.addPayment(25);
	  Receipt r = ps.buy();
	  assertEquals( "Should display 16 min", 
			  40 / 5 * 2, r.value() );
  }
  
  /** 
   * Escollim el test “buy for 100 cents”
   */
  @Test
  public void buyFor100Cents() throws IllegalCoinException {
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  ps.addPayment(5);
	  Receipt r = ps.buy();
	  assertEquals( "Should display 40 min", 
			  100 / 5 * 2, r.value() );
  }
  
  /** 
   * Escollim el test “clearing after a buy operation”
   */
  @Test
  public void clearingAfterABuyOperation() throws IllegalCoinException {
	  ps.addPayment(5);
	  ps.addPayment(10);
	  ps.addPayment(25);
	  Receipt r = ps.buy();
	  assertEquals( "Should display 0", 
	            0, ps.readDisplay() );
	  ps.addPayment(5);
	  ps.addPayment(10);
	  ps.addPayment(5);
	  ps.addPayment(10);
	  r = ps.buy();
	  assertEquals( "Should display 12 min", 
			  30 / 5 * 2, r.value() );
	  assertEquals( "Should display 0", 
	            0, ps.readDisplay() );
  }
  /** 
   * Escollim el test “cancel resets pay station”
   */
  @Test
  public void CancelResetsPayStation() throws IllegalCoinException {
	
	  ps.addPayment(5);
	  ps.addPayment(10);
	  ps.addPayment(5);
	  ps.addPayment(10);
	  ps.cancel();
	  assertEquals( "Should display 0", 
	            0, ps.readDisplay() );
  }
  /** 
   * Escollim el test “ShowCalers”
   */
  @Test
  public void ShowCalers() throws NoCalersException, IllegalCoinException {
	  ps.addPayment(5);
	  ps.addPayment(10);
	  ps.addPayment(25);
	  Receipt r = ps.buy();
	  ps.addPayment(5);
	  ps.addPayment(10);
	  ps.addPayment(5);
	  ps.addPayment(10);
	  r = ps.buy();
	  int res = ps.showCalers();
	  assertEquals( "Should display 70", 
	            70, res );
  }
  /** 
   * Escollim el test "BuidaExc"
   */
  @Test(expected=NoCalersException.class)
  public void BuidaExc() throws NoCalersException {
	  ps.showCalers();
  }
}
