-- --------------------------------------------------------

--
-- Структура таблицы `authors`
--

CREATE TABLE `authors` (
  `id_Author` INTEGER NOT null PRIMARY KEY,
  `AFullName` TEXT NOT null,
  `ADate_of_Birth` TEXT DEFAULT null,
  `ADescription` TEXT DEFAULT null,
  `Foto` TEXT DEFAULT 'fotos/no_foto.jpg'
);

--
-- Дамп данных таблицы `authors`
--

INSERT INTO `authors` (`id_Author`, `AFullName`, `ADate_of_Birth`, `ADescription`, `Foto`) VALUES
(1, 'Сара Дж. Маас', '2021-05-01', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://u.livelib.ru/author/1000357494/r/650870u8/Sarah_J._Maas-r.jpg'),
(2, 'Керри Манискалко', '2021-05-02', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://i0.wp.com/kerrimaniscalco.com/wp-content/uploads/2010/04/kerri-maniscalco-promo-shots.jpg'),
(3, 'Виктория Авеярд', '2021-05-03', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://fantasy-worlds.org/writer/4688.jpg'),
(4, 'Холли Блэк', '2021-05-04', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://u.livelib.ru/author/1000031182/r/ndkkvxaj/Holly_Black-r.jpg'),
(5, 'Лия Арден', '2021-05-05', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://images.eksmo.ru/upload/authors/46b/338_2_min.jpg'),
(6, 'Антонина Крейн', '2021-05-06', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://u.livelib.ru/author/1001180506/r/min74l5s/Antonina_Krejn-r.jpg'),
(7, 'Риттер Уильям', '2021-05-07', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://fantasy-worlds.org/writer/4963.jpg'),
(8, 'Аннетт Мари', '2021-05-08', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://www.litmir.me/data/Author/280000/280295/%D0%A4%D0%BE%D1%82%D0%BE_%D0%90%D0%BD%D0%BD%D0%B5%D1%82%D1%82_%D0%9C%D0%B0%D1%80%D0%B8_e07f8.jpg'),
(9, 'Синди Энсти', '2021-05-09', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://i0.wp.com/pickagoodbook.com/wp-content/uploads/2019/04/Cindy-Anstey.jpg?resize=230%2C230'),
(10, 'Татьяна Полякова', '2021-05-10', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://images.eksmo.ru/upload/authors/9b3/polyakova_03.jpg'),
(11, 'Миэ Со', '2021-05-11', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://www.litmir.me/data/Author/324000/324121/%D0%A4%D0%BE%D1%82%D0%BE_%D0%9C%D0%B8%D1%8D_%D0%A1%D0%BE_77af0.jpg'),
(12, 'Карризи Донато', '2021-05-12', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://litres.ru/static/authors/100/03/79/21/03792140.jpg'),
(13, 'Марисса Мейер', '2021-05-13', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://pbs.twimg.com/profile_images/1133068768932794368/GJySN1oN_400x400.png'),
(14, 'Анастасия Гор', '2021-05-14', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://images.gr-assets.com/authors/1625908927p5/20256653.jpg'),
(15, 'Патрик Несс', '2021-05-15', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://avatars.mds.yandex.net/get-kinopoisk-image/1777765/7b5d3ed5-c18d-45ed-87a2-a4c8cf02b7d6/360'),
(16, 'Стивен Кинг', '2021-05-16', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://media.bonnierforlagen.se/forfattarfotonstandard/b/39160b.jpg'),
(17, 'Брайан Герберт', '2021-05-17', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://adebiportal.kz/images/w350-cct-si/upload/8941/2019/06/26/7a8556e9b574ef16c93f799f825f4181.jpg'),
(18, 'Кевин Андерсон', '2021-05-18', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 'https://static.wikia.nocookie.net/dune/images/9/9f/Kevin_J_Anderson.jpg/revision/latest?cb=20160713093806&path-prefix=ru'),
(20, 'Василий Пупкин', '2021-03-06', 'Блабла', 'https://pbs.twimg.com/profile_images/998303024240967680/CExN0ASR_400x400.jpg'); --LOL--

-- --------------------------------------------------------

--
-- Структура таблицы `books`
--

CREATE TABLE `books` (
  `id_Book` INTEGER NOT null PRIMARY KEY,
  `Title` TEXT DEFAULT null,
  `BDescription` TEXT DEFAULT null,
  `ISBN` TEXT DEFAULT null,
  `YDK` TEXT DEFAULT null,
  `BBK` TEXT DEFAULT null,
  `id_Category` INTEGER DEFAULT null,
  `id_Seria` INTEGER DEFAULT null,
  `id_Cycle` INTEGER DEFAULT null,
  `id_Format` INTEGER DEFAULT null,
  `Year` INTEGER DEFAULT null,
  `Number_of_pages` INTEGER DEFAULT null,
  `Weight` REAL DEFAULT null,
  `Age` TEXT DEFAULT null,
  `Cover` TEXT DEFAULT 'https://covers.openlibrary.org/w/id/10408030-M.jpg',
  `Сirculation` INTEGER DEFAULT null,
  `Binding` TEXT DEFAULT null,
  `Status` TEXT DEFAULT null,
  `is_Shown` INTEGER DEFAULT 1,
  `Number_in_Cycle` INTEGER DEFAULT null,
  `is_Best` INTEGER NOT null DEFAULT 0,
  `snippet_Url` TEXT DEFAULT null
);

--
-- Дамп данных таблицы `books`
--

INSERT INTO `books` (`id_Book`, `Title`, `BDescription`, `ISBN`, `YDK`, `BBK`, `id_Category`, `id_Seria`, `id_Cycle`, `id_Format`, `Year`, `Number_of_pages`, `Weight`, `Age`, `Cover`, `Сirculation`, `Binding`, `Status`, `is_Shown`, `Number_in_Cycle`, `is_Best`, `snippet_Url`) VALUES
(1, 'Стеклянный трон', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-389-04531-6', null, null, 1, 1, 1, 1, 2012, 480, 0.25, '16', 'covers/1.jpg', 5000, 'твердый', 'вышла', 1, 1, 1, 'https://cdn.book24.ru/v2/ITD000000001137578/PDF/ITD000000001137578.pdf'),
(2, 'Охота на Джека-Потрошителя', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-17-982482-4', null, null, 2, 2, 2, 2, 2018, 416, 0.39, '16', 'covers/2.jpg', null, 'твердый', 'вышла', 1, 1, 0, 'https://cdn.book24.ru/v2/ASE000000000832508/PDF/ASE000000000832508.pdf'),
(3, 'Алая королева', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-04-103445-0', null, null, 1, 5, 3, 2, 2019, 544, 0.5, '16', 'covers/3.jpg', 30000, 'твердый', 'вышла', 1, 1, 1, 'https://cdn.book24.ru/v2/ITD000000000972713/PDF/ITD000000000972713.pdf'),
(4, 'Мара и Морок', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-04-107175-2', null, null, 1, 3, 4, 2, 2020, 384, 0.38, '16', 'covers/4.jpg', 42000, 'твердый', 'вышла', 1, 2, 0, 'https://cdn.book24.ru/v2/ITD000000001050995/PDF/ITD000000001050995.pdf'),
(5, 'Шолох. Теневые блики', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-04-111933-1', null, null, 1, 4, 5, 1, 2021, 544, 0.45, '16', 'covers/5.jpg', 5000, 'мягкий', 'вышла', 1, 1, 0, 'https://cdn.book24.ru/v2/ITD000000001072122/PDF/ITD000000001072122.pdf'),
(6, 'Королевство гнева и тумана', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-389-12106-5', null, null, 1, 1, 6, 2, 2017, 704, 0.1, '16', 'covers/6.jpg', 5000, 'твердый', 'вышла', 1, 2, 0, 'https://cdn.book24.ru/v2/ITD000000001144153/PDF/ITD000000001144153.pdf'),
(7, 'Kingdom of the Wicked', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', null, null, null, 2, 2, null, null, 2021, null, null, null, 'covers/7.jpg', null, 'твердый', 'права куплены', 1, 1, 0, 'https://cdn.book24.ru/v2/ASE000000000853699/PDF/ASE000000000853699.pdf'),
(8, 'Жестокий принц', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-04-090470-9', null, null, 1, 5, 7, 2, 2018, 480, 0.46, '16', 'covers/8.jpg', 41000, 'твердый', 'вышла', 1, 1, 0, 'https://cdn.book24.ru/v2/ITD000000000888157/PDF/ITD000000000888157.pdf'),
(9, 'Золото в темной ночи', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-04-111953-9', null, null, 1, 3, 8, 2, 2020, 384, 0.42, '16', 'covers/9.jpg', 12000, 'твердый', 'вышла', 1, 1, 0, 'https://cdn.book24.ru/v2/ITD000000001093678/PDF/ITD000000001093678.pdf'),
(10, 'Джекаби', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-17-105104-4', null, null, 2, 6, null, 2, 2018, 320, 0.3, '12', 'covers/10.jpg', null, 'твердый', 'вышла', 1, 1, 0, 'https://cdn.book24.ru/v2/ASE000000000831860/PDF/ASE000000000831860.pdf'),
(11, 'Алая зима', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-17-114127-1', null, null, 1, 5, null, 2, 2019, 384, 0.38, '16', 'covers/11.jpg', null, 'твердый', 'вышла', 1, 1, 0, 'https://cdn.book24.ru/v2/ASE000000000842398/PDF/ASE000000000842398.pdf'),
(12, 'Кинжал-Колибри', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-17-119470-3', null, null, 2, 6, null, 2, 2021, 416, 0.41, '16', 'covers/12.jpg', null, 'твердый', 'вышла', 1, null, 1, 'https://cdn.book24.ru/v2/ASE000000000847856/PDF/ASE000000000847856.pdf'),
(13, 'Особняк с выходом в астрал', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-04-120281-1', null, null, 2, 6, null, 2, 2021, 320, 0.32, '16', 'covers/13.jpg', null, 'твердый', 'вышла', 1, null, 1, 'https://cdn.book24.ru/v2/ITD000000001117673/PDF/ITD000000001117673.pdf'),
(14, 'Единственный ребенок', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-04-113678-9', null, null, 2, 6, null, 1, 2021, 352, 0.37, '16', 'covers/14.jpg', 10000, 'твердый', 'вышла', 1, null, 0, 'https://cdn.book24.ru/v2/ITD000000001107498/PDF/ITD000000001107498.pdf'),
(15, 'Дом голосов', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-389-19101-3', null, null, 2, 6, null, 2, 2021, 352, 0.46, '16', 'covers/15.jpg', 3000, 'твердый', 'вышла', 1, null, 0, 'https://cdn.book24.ru/v2/ITD000000001158365/PDF/ITD000000001158365.pdf'),
(16, 'Золушка', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-17-122190-4', null, null, 3, 4, null, 2, 2021, 416, 0.36, '16', 'covers/16.jpg', null, 'твердый', 'вышла', 1, null, 0, 'https://cdn.book24.ru/v2/ASE000000000850681/PDF/ASE000000000850681.pdf'),
(17, 'Ковен озера Шамплейн', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-04-112010-8', null, null, 3, 4, null, 2, 2021, 544, 0.45, '18', 'covers/17.jpg', 3000, 'твердый', 'вышла', 1, null, 0, 'https://cdn.book24.ru/v2/ITD000000001093886/PDF/ITD000000001093886.pdf'),
(18, 'Вопрос и ответ', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-04-120667-3', null, null, 3, 4, null, 2, 2021, 480, 0.59, '16', 'covers/18.jpg', 4000, 'твердый', 'вышла', 1, null, 1, 'https://cdn.book24.ru/v2/ITD000000001126300/PDF/ITD000000001126300.pdf'),
(19, 'Институт', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-17-120968-1', null, null, 3, 4, null, 2, 2021, 608, 0.55, '16', 'covers/19.jpg', null, 'твердый', 'вышла', 1, null, 0, 'https://cdn.book24.ru/v2/ASE000000000849429/PDF/ASE000000000849429.pdf'),
(20, 'Битва при Коррине', 'Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio, cumque nihil impedit, quo minus id, quod maxime placeat, facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet, ut et voluptates repudiandae sint  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', '978-5-17-133304-1', null, null, 3, 4, null, 2, 2021, 800, 0.64, '16', 'covers/20.jpg', null, 'твердый', 'вышла', 1, null, 0, 'https://cdn.book24.ru/v2/ASE000000000854057/PDF/ASE000000000854057.pdf');

-- --------------------------------------------------------

--
-- Структура таблицы `books_has_authors`
--

CREATE TABLE `books_has_authors` (
  `id_Book` INTEGER NOT null,
  `id_Author` INTEGER NOT null,
  PRIMARY KEY (`id_Book`, `id_Author`)
);

--c
-- Дамп данных таблицы `books_has_authors`
--

INSERT INTO `books_has_authors` (`id_Book`, `id_Author`) VALUES
(1, 1),
(6, 1),
(2, 2),
(7, 2),
(3, 3),
(8, 4),
(4, 5),
(5, 6),
(9, 5),
(10, 7),
(11, 8),
(12, 9),
(13, 10),
(14, 11),
(15, 12),
(16, 13),
(17, 14),
(18, 15),
(19, 16),
(20, 17),
(20, 18);

-- --------------------------------------------------------

--
-- Структура таблицы `books_has_translators`
--

CREATE TABLE `books_has_translators` (
  `id_Book` INTEGER NOT null,
  `id_Translator` INTEGER NOT null,
  PRIMARY KEY (`id_Book`, `id_Translator`)
);

--
-- Дамп данных таблицы `books_has_translators`
--

INSERT INTO `books_has_translators` (`id_Book`, `id_Translator`) VALUES
(1, 1),
(6, 1),
(2, 2),
(3, 3),
(8, 4),
(14, 5),
(20, 6);

-- --------------------------------------------------------

--
-- Структура таблицы `category`
--

CREATE TABLE `category` (
  `id_Category` INTEGER NOT null PRIMARY KEY,
  `TitleRus` TEXT DEFAULT null,
  `TitleEng` TEXT DEFAULT null,
  `CatDescription` TEXT DEFAULT null
);

--
-- Дамп данных таблицы `category`
--

INSERT INTO `category` (`id_Category`, `TitleRus`, `TitleEng`, `CatDescription`) VALUES
(1, 'Фэнтези', 'Fantasy', null),
(2, 'Детективы', 'Detective', null),
(3, 'Фантастика', 'Fiction', null);

-- --------------------------------------------------------

--
-- Структура таблицы `cycles`
--

CREATE TABLE `cycles` (
  `id_Cycle` INTEGER NOT null PRIMARY KEY,
  `CycTitle` TEXT DEFAULT null,
  `Quantity` INTEGER DEFAULT null
);

--
-- Дамп данных таблицы `cycles`
--

INSERT INTO `cycles` (`id_Cycle`, `CycTitle`, `Quantity`) VALUES
(1, 'Стеклянный трон', 8),
(2, 'Охота на Джека-Потрошителя', 4),
(3, 'Алая королева', 5),
(4, 'Мара и Морок', 3),
(5, 'Шолох', 3),
(6, 'Королевство шипов и роз', 6),
(7, 'Небесный народец', 4),
(8, 'Потомки первых', 4),
(9, 'Мистические расследования Джекаби', 4),
(10, 'Воронята', 5);

-- --------------------------------------------------------

--
-- Структура таблицы `formats`
--

CREATE TABLE `formats` (
  `id_Format` INTEGER NOT null PRIMARY KEY,
  `Width` REAL DEFAULT null,
  `Height` REAL DEFAULT null
);

--
-- Дамп данных таблицы `formats`
--

INSERT INTO `formats` (`id_Format`, `Width`, `Height`) VALUES
(1, 34, 126),
(2, 130, 205),
(8, 120, 321);

-- --------------------------------------------------------

--
-- Структура таблицы `series`
--

CREATE TABLE `series` (
  `id_Seria` INTEGER NOT null PRIMARY KEY,
  `SerTitle` TEXT DEFAULT null,
  `SerDescription` TEXT DEFAULT null
);

--
-- Дамп данных таблицы `series`
--

INSERT INTO `series` (`id_Seria`, `SerTitle`, `SerDescription`) VALUES
(1, 'Волшебные миры Сары Дж. Маас', null),
(2, 'Расследования Керри Манискалко', null),
(3, 'Избранное российское фэнтези', null),
(4, 'Миры фантастики', null),
(5, 'Фэнтезийные зарубежные миры', null),
(6, 'Детективные расследования', null);

-- --------------------------------------------------------

--
-- Структура таблицы `translators`
--

CREATE TABLE `translators` (
  `id_Translator` INTEGER NOT null PRIMARY KEY,
  `TFullName` TEXT DEFAULT null
);

--
-- Дамп данных таблицы `translators`
--

INSERT INTO `translators` (`id_Translator`, `TFullName`) VALUES
(1, 'Иван Иванов'),
(2, 'Татьяна Ибрагимова'),
(3, 'Валентина Сергеева'),
(4, 'Сергей Самуйлов'),
(5, 'Артем Лисочкин'),
(6, 'Александр Анваер'),
(12, 'Три пять'),
(13, 'Раз два');

-- --------------------------------------------------------