insert into CATEGORY (ID, NAME) values
  -- Main categories
  (1, 'Firearms'), (2, 'Ammo'), (3, 'Optics'), (4, 'Knives'), (5, 'Suppressors'),

  -- Firearms subcategories
  (6, 'Handguns'), (7, 'Revolvers'), (8, 'Semi-Automatic'), (9, 'Automatic'),
  (10, 'Shotguns'), (11, 'Pump Action'), (12, 'Lever Action'), (13, 'Single Shot'),
  (14, 'Rifles'), (15, 'Bolt Action'),

  -- Ammo subcategories
  (16, 'Bulk Ammo'), (17, 'Blanks'),

  -- Optics subcategories
  (18, 'Binoculars'), (19, 'Flashlights'), (20, 'Night Vision'), (21, 'Rangefinder'),
  (22, 'Scope Mounts'), (23, 'Scopes'), (24, 'Lasers'), (25, 'Sights'),
  (26, 'Spotting Scopes'), (27, 'Thermal Optics'),

  -- Knives subcategories
  (28, 'Fixed Blade'), (29, 'Folding Blade'), (30, 'Accessories'), (31, 'Utility');

insert into MANUFACTURER (ID, NAME) values
  (1, 'Barret'), (2, 'Beretta'), (3, 'CCI'), (4, 'CZ-USA'), (5, 'EOTech'),
  (6, 'Federal'), (7, 'Glock'), (8, 'HK'), (9, 'Kel-Tech'), (10, 'Mossberg'),
  (11, 'Remington'), (12, 'TULAMMO'), (13, 'Winchester'), (14, 'Wolf'), (15, 'Walther');

insert into PRODUCT (ID, MANUFACTURER_ID, NAME, DESCRIPTION, SPECIFICATIONS, PRICE)
values
  (1, 1, 'Barrett M107 A1 Semi-Automatic 50 Browning Machine Gun (BMG) 29" 10+1 Fixed Blk Stk Blk Cerakote',
   'Designed to be used with a suppressor, this one-of-a-kind rifle allows you ' ||
   'to combine signature reduction capabilities with the flawless reliability ' ||
   'of the original Barrett M107, but with a rifle weight reduction of 5 ' ||
   'pounds. An all new bolt carrier group has been designed and is key to ' ||
   'making the rifle suppressor ready. Its steel four port cylindrical muzzle ' ||
   'brake is engineered to work seamlessly with a quick attach Barrett QDL ' ||
   'Suppressor. The lightweight aluminum upper receiver features an integrated ' ||
   '27 MOA optics rail. Inside the upper receiver, the bolt carrier rides on a ' ||
   'hardened steel anti wear strip for added durability. A thermal-guard cheek ' ||
   'piece protects the user''s face from extreme heat or cold. Advanced design ' ||
   'and manufacturing make the M107A1 more precise than ever. The rear barrel ' ||
   'stop and front barrel bushing are bolted and bonded with a high strength ' ||
   'compound. A titanium barrel key and fully-chrome-lined bore and chamber add ' ||
   'to the rifle''s durability. Enhanced modularity is also a key feature of the ' ||
   'M107A1. The rail mounted aluminum rear grip can easily be reconfigured. The ' ||
   'newly designed titanium and polymer monopod is adjustable from either side. ' ||
   'The M107A1 rifle''s lower receiver includes a new aluminum recoil buffer ' ||
   'system that''s optimized for use with the Barrett QDL Suppressor. The bolt ' ||
   'carrier''s components are protected with a mix of ultra hard coatings and ' ||
   'advanced nickel Teflon plating that increases lubricity, is corrosion ' ||
   'resistant and greatly eases cleaning.Numbered witness holes on the magazine ' ||
   'are just another example of how even the smallest detail makes a powerful ' ||
   'difference.',
   'Category: RIFLES CENTERFIRE TACTICAL, Action: Semi-Automatic, ' ||
   'Caliber: 50 Browning Machine Gun (BMG), Barrel Length: 29", Capacity: 10+1, ' ||
   'Trigger: Standard, Safety: Thumb Lever, OAL: 57", Weight: 28.7 lbs, ' ||
   'Stock Description: Fixed Black, Metal Finish: Black Cerakote, ' ||
   'Muzzle: Suppressor Ready Muzzle Brake, Receiver Material: Aluminum, ' ||
   'Sights: Flip-Up Iron Rear, Barrel Description: Fluted, Twist: 1:15", ' ||
   'Barrel Length Range: 28.00" to 29.99", Weight Range: 20.00 lbs and Above, ' ||
   'Hand: Right, Stock Finish Group: Synthetic, Metal Finish Group: Blued/Black', 12067.06);

insert into CATEGORY_PRODUCT (CATEGORY_ID, PRODUCT_ID) values (1, 1);
