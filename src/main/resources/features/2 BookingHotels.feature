Feature: Booking Hotels Customer
 Scenario: Testing menu booking Hotels
  When Customer klik menu Hotels
  Then Customer melihat page Hotels 
  When Customer klik button search Hotels
  And Customer search Hotels with location Singapore
  And Customer klik button checkin
  And Customer klik button checkout
  And Customer klik button Travellers
  And Customer klik button Submit
  Then Customer melihat page Hotels in singapore
  When Customer klik button Details