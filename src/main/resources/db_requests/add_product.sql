INSERT INTO `mydb`.`product` (`id`, `article`, `created_at`, `description`, `image_path`, `name`, `new_product`, `price`) VALUES ('2', '1002', '2029-05-20', 'Нарядный и в то же время относительно простой летний сарафан, выполнен из легкого хлопка. Полуприлегание и облегчённая ткань обеспечат комфортную носку даже в самые знойные дни. Застёжка на пуговицах. Юбка имеет небольшую сборку по линии талии. Благодаря завязкам на плечах прекрасно отрегулируется на любой рост. Универсальный крой, сочетающийся как с туфлями так и с кедами- сделают это изделие', 'baby.jpg', 'Сарафан', '1', '430');
INSERT INTO `mydb`.`product` (`id`, `article`, `created_at`, `description`, `image_path`, `name`, `new_product`, `price`) VALUES ('3', '1003', '2029-05-20', 'Нарядный и в то же время относительно простой летний сарафан, выполнен из легкого хлопка. Полуприлегание и облегчённая ткань обеспечат комфортную носку даже в самые знойные дни. Застёжка на пуговицах. Юбка имеет небольшую сборку по линии талии. Благодаря завязкам на плечах прекрасно отрегулируется на любой рост. Универсальный крой, сочетающийся как с туфлями так и с кедами- сделают это изделие', 'baby.jpg', 'Юбка', '1', '120');
INSERT INTO `mydb`.`product` (`id`, `article`, `created_at`, `description`, `image_path`, `name`, `new_product`, `price`) VALUES ('4', '1004', '2029-05-20', 'Нарядный и в то же время относительно простой летний сарафан, выполнен из легкого хлопка. Полуприлегание и облегчённая ткань обеспечат комфортную носку даже в самые знойные дни. Застёжка на пуговицах. Юбка имеет небольшую сборку по линии талии. Благодаря завязкам на плечах прекрасно отрегулируется на любой рост. Универсальный крой, сочетающийся как с туфлями так и с кедами- сделают это изделие', 'baby.jpg', 'Сарафан', '1', '130');
INSERT INTO `mydb`.`product` (`id`, `article`, `created_at`, `description`, `image_path`, `name`, `new_product`, `price`) VALUES ('5', '1005', '2029-05-20', 'Нарядный и в то же время относительно простой летний сарафан, выполнен из легкого хлопка. Полуприлегание и облегчённая ткань обеспечат комфортную носку даже в самые знойные дни. Застёжка на пуговицах. Юбка имеет небольшую сборку по линии талии. Благодаря завязкам на плечах прекрасно отрегулируется на любой рост. Универсальный крой, сочетающийся как с туфлями так и с кедами- сделают это изделие', 'baby.jpg', 'Платье', '1', '110');
INSERT INTO `mydb`.`product` (`id`, `article`, `created_at`, `description`, `image_path`, `name`, `new_product`, `price`) VALUES ('6', '1006', '2029-05-20', 'Нарядный и в то же время относительно простой летний сарафан, выполнен из легкого хлопка. Полуприлегание и облегчённая ткань обеспечат комфортную носку даже в самые знойные дни. Застёжка на пуговицах. Юбка имеет небольшую сборку по линии талии. Благодаря завязкам на плечах прекрасно отрегулируется на любой рост. Универсальный крой, сочетающийся как с туфлями так и с кедами- сделают это изделие', 'baby.jpg', 'Юбка', '1', '100');
UPDATE `mydb`.`product` SET `id` = '1', `article` = '1001', `price` = '460' WHERE (`id` = '1');



UPDATE `mydb`.`product` SET `image_path` = 'card1.jpg', `name` = 'Костюм оверсайз', `old_price` = '350', `price` = '290' WHERE (`id` = '1');
UPDATE `mydb`.`product` SET `image_path` = 'card2.jpg', `name` = 'Плащ' WHERE (`id` = '2');
UPDATE `mydb`.`product` SET `image_path` = 'card3.jpg', `name` = 'Жакет' WHERE (`id` = '3');
UPDATE `mydb`.`product` SET `image_path` = 'card4.jpg' WHERE (`id` = '4');
UPDATE `mydb`.`product` SET `image_path` = 'card5.jpg', `name` = 'Водолазка' WHERE (`id` = '5');
UPDATE `mydb`.`product` SET `image_path` = 'card6.jpg', `name` = 'Рубашка', `price` = '113' WHERE (`id` = '6');
INSERT INTO `mydb`.`product` (`id`, `article`, `created_at`, `description`, `image_path`, `name`, `new_product`, `price`) VALUES ('7', '1007', '2029-05-20', 'Нарядный и в то же время относительно простой летний сарафан, выполнен из легкого хлопка. Полуприлегание и облегчённая ткань обеспечат комфортную носку даже в самые знойные дни. Застёжка на пуговицах. Юбка имеет небольшую сборку по линии талии. Благодаря завязкам на плечах прекрасно отрегулируется на любой рост. Универсальный крой, сочетающийся как с туфлями так и с кедами- сделают это изделие', 'card7.jpg', 'Платье', '1', '125');
INSERT INTO `mydb`.`product` (`id`, `article`, `created_at`, `description`, `image_path`, `name`, `new_product`, `price`) VALUES ('8', '1008', '2029-05-20', 'Нарядный и в то же время относительно простой летний сарафан, выполнен из легкого хлопка. Полуприлегание и облегчённая ткань обеспечат комфортную носку даже в самые знойные дни. Застёжка на пуговицах. Юбка имеет небольшую сборку по линии талии. Благодаря завязкам на плечах прекрасно отрегулируется на любой рост. Универсальный крой, сочетающийся как с туфлями так и с кедами- сделают это изделие', 'baby.jpg', 'Платье', '1', '178');


UPDATE `mydb`.`product` SET `image_path` = 'card1.png' WHERE (`id` = '1');
UPDATE `mydb`.`product` SET `image_path` = 'card2.png' WHERE (`id` = '2');
UPDATE `mydb`.`product` SET `image_path` = 'card3.png' WHERE (`id` = '3');
UPDATE `mydb`.`product` SET `image_path` = 'card4.png' WHERE (`id` = '4');
UPDATE `mydb`.`product` SET `image_path` = 'card5.png' WHERE (`id` = '5');
UPDATE `mydb`.`product` SET `image_path` = 'card6.png' WHERE (`id` = '6');
UPDATE `mydb`.`product` SET `image_path` = 'card7.png' WHERE (`id` = '7');