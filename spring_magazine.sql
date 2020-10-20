-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : mar. 20 oct. 2020 à 09:01
-- Version du serveur :  5.7.24
-- Version de PHP : 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `spring_magazine`
--

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

CREATE TABLE `articles` (
  `id` bigint(20) NOT NULL,
  `author` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `title` varchar(255) NOT NULL,
  `collection_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `articles`
--

INSERT INTO `articles` (`id`, `author`, `description`, `title`, `collection_id`) VALUES
(1, 'John Doe', 'Since it was revealed that White House adviser Hope Hicks had tested positive for COVID-19, nearly a dozen other cases in Washington, D.C., have come to light, including that of President Donald Trump.\r\n\r\nHere\'s a look at prominent political players ABC News has confirmed have tested positive or negative for the virus since Hicks\' case so far. Among the positive cases are several attendees of key events at the White House this past week: the SCOTUS nomination last Saturday and a prep session on Monday ahead of the first presidential debate. Several were also at the debate itself on Tuesday in Cleveland.', 'COVID-19 in DC.', 1),
(2, 'John Doe', 'New Jersey’s 30-year experiment shows how hard it is to truly fulfill promises to make public schools equitable, something that has been a cornerstone of protests this year after George Floyd’s killing in Minnesota that brought attention to racial and socioeconomic inequities across the U.S. The progressive policy became the subject of never-ending court battles, rancorous debates from Democrats and Republicans alike over who deserves state resources and a cost driver for the state budget, a third of which now goes to education aid.\r\n\r\nInstead of making continual progress on funding, New Jersey is \"backsliding,\" says researcher Bruce Baker.\r\n\r\n“For the last decade, it’s really kind of fallen apart,” Baker, professor at Rutgers University‘s Graduate School of Education, said of school funding in New Jersey. “New Jersey schools now are about as equitable as they were in the early 1990s.”', 'New Jersey school inequity', 1),
(3, 'John Doe', 'Fontana acknowledges that the crisis had a devastating effect on EU the economy, on supplies and making sure the right things were in place at the right time.\r\n\r\nHe said: “I think that we need protection, but not protectionism. We do not want isolation. We want to have continued global collaboration.”\r\n\r\nHe went to say that coming out of the Covid-19 pandemic was going to be a challenge for all of us. Moreover, this was an opportunity for the EU to show that its response can make a difference.\r\n\r\nThe EU has plans to introduce €750bn into its economy via what it calls the Next Generation Fund. However, Fontana added that the most important thing was to try to have a common response to a common problem.\r\n\r\n“But there cannot be one recipe for all the member states,\" he said, \"Because the economies are different, the demography is different. So, we have to leave them some leeway in adopting the recipes to what are the local challenges.”\r\n\r\nFontana says Europe has a good relationship with the United Arab Emirates and wants to build on it. The EU is one of the major trading blocs with the UAE. Last year the European Union traded in goods to the value of €50bn. That puts it in the top three of the trading blocs with the country.\r\n\r\nThe EU opened its delegation in the country in 2013, with the goal of strengthening the Union’s cooperation as well as intensify bilateral relations with the UAE.', 'Europe and UAE working towards a sustainable future', 1),
(4, 'John Doe', 'What Brexit actually triggered was a lot of support of European Union members,” Haavisto said. “They see how difficult it is to leave and how many agreements they have to make if they leave the EU so maybe it’s better to stay.”\r\n\r\nIt had long been feared that the UK\'s departure from the European Union might pave the way for other members to follow suit, however, Haavisto instead insists that the EU has a way of surviving these perceived crises.\r\n\r\n“I think Europe is very good at surviving,” Haavisto said. “We have already many times been thinking this is the end but then something has happened and we have been more successful.', 'Brexit can be good for Europe', 1),
(5, 'Marie Doe', 'Jürgen Klopp watched his Liverpool team crash to an extraordinary 7-2 defeat at Aston Villa and questioned the lack of reaction after a grisly early concession, and the desire of his players.\r\n\r\nThe manager had lost his first-choice goalkeeper, Alisson, to a shoulder injury in training – he will be out for four to six weeks – and the replacement, Adrián, handed Villa the breakthrough with a loose pass out from the back.\r\n\r\nThe goal was scored by Ollie Watkins, the £28m signing from Brentford, and he finished with a hat-trick. Jack Grealish scored two while Ross Barkley marked his Villa debut with a goal and John McGinn got the other. Mohamed Salah scored both for Liverpool on an evening when their high defensive line was taken apart.', 'Jürgen Klopp is not amused', 2),
(6, 'Marie Doe', 'Alexander Zverev has revealed that he competed while sick with breathing issues and fever during his 6-3, 6-3, 4-6, 6-3 loss to Jannik Sinner of Italy in the Roland Garros fourth round. The 23-year-old received on-court treatment by a tournament doctor and he was pictured coughing after his first discussion with the medic while trailing 1-4 in the first set. He later said that he suffered a 38C fever on Saturday night, a possible symptom of Covid-19.\r\n\r\n“What can I say? I’m completely sick,” he said in his post-match press conference. “I can’t really breathe, as you can hear by my voice. I had fever, you know, as well. Yeah, I’m not in the best physical state, I would say. I think that had a little bit of an effect on the match today.”\r\n\r\nIn a statement, the Fédération Française de Tennis noted that Zverev had come out negative in his previously scheduled Covid-19 tests, but he has not been tested in five days. He did not inform the tournament of his ailment before arriving on court.', 'Tennis man Alexander Zverev played with fever', 2),
(7, 'Marie Doe', 'With his second assist in Sunday\'s Game 3 of The Finals, the 1,840th of his NBA playoff career, LeBron James moved into second place on the league\'s all-time leaderboard.\r\n\r\nHolding the ball on the left wing, looking for an opening, he spotted Dwight Howard making a backdoor cut and delivered a clean alley-oop.\r\n\r\nJames passed Jazz legend John Stockton, and now trails only Lakers great Magic Johnson, whose total towers above the field at 2,346. If James were to maintain his current playoff average (7.2 apg), he\'d require another 70 games to make up the 506-assist differential.', 'LeBron James claims 2nd place on all-time playoffs assists leaderboard', 2),
(8, 'Lisa Doe', 'New research shows that one common weight loss strategy — time-restricted eating — isn’t more effective than eating throughout the day.\r\n\r\nA team of researchers from the University of California San Francisco and other institutions released their findingsTrusted Source last week.\r\n\r\nFor their study, they created two groups comprising 116 participants.\r\n\r\nOne group ate 3 structured meals per day, while the other ate nothing between 8 p.m. and noon the following day.\r\n\r\n“Time-restricted eating, in the absence of other interventions, is not more effective in weight loss than eating throughout the day,” the researchers wrote.\r\n\r\nDespite the study’s conclusions, experts interviewed by Healthline say there’s more than meets the eye when it comes to time-restricted diets and individualized weight loss.', 'Are time-restricted diets more effective Than food-restrictive diets ?', 3),
(9, 'Lisa Doe', 'When Julianna Marrone made the difficult decision with her family to place her father, Jay, in long-term care for his dementia, she knew they were in for a long, hard haul.\r\n\r\nMarrone knew she wouldn’t be able to see her dad as often as before. She also knew she’d have to trust strangers to watch over him when other family members were not on hand.\r\n\r\nWhat she didn’t know was that the COVID-19 pandemic was going to take that difficult situation and make it even harder — both for her father and all the family members who care about him.\r\n\r\n“My father’s natural therapy and medication is his family,” Marrone told Healthline. “When I visit my father, his eyes fill up whenever he tells me, ‘I love you.’ All he wants is his family.”\r\n\r\nBut with restrictions on visitors and no way to move their father elsewhere and get the support he needs, the family is stuck, watching and knowing that the situation may not be the best one for him.\r\n\r\n“The situation with my dad has been awful,” Danielle Westgate, Marrone’s sister, told Healthline. “He regressed so much during quarantine.”\r\n\r\nLike many people in both palliative care and hospice care across the country, Marrone and her family found themselves in a difficult situation.', 'No hugs: how covid-19 impacted palliative Hospice Care', 3);

-- --------------------------------------------------------

--
-- Structure de la table `collections`
--

CREATE TABLE `collections` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `collections`
--

INSERT INTO `collections` (`id`, `name`) VALUES
(3, 'Health'),
(1, 'Politic'),
(2, 'Sport');

-- --------------------------------------------------------

--
-- Structure de la table `comments`
--

CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `message` text NOT NULL,
  `title` varchar(255) NOT NULL,
  `article_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `comments`
--

INSERT INTO `comments` (`id`, `created_at`, `message`, `title`, `article_id`) VALUES
(1, '2020-10-19 15:46:08', 'Hello everyone', 'Wonderful', 1),
(2, '2020-10-19 15:53:34', 'I love it', 'Superbe', 1),
(3, '2020-10-19 15:53:42', 'I love it', 'Superbe', 2),
(4, '2020-10-19 15:53:47', 'I love it', 'Wonderful', 2),
(5, '2020-10-19 15:54:10', 'I liked what I read', 'Very concise', 1);

-- --------------------------------------------------------

--
-- Structure de la table `images`
--

CREATE TABLE `images` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `article_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `images`
--

INSERT INTO `images` (`id`, `name`, `article_id`) VALUES
(1, 'politic-01_a.png', 1),
(2, 'politic-01_b.png', 1),
(3, 'politic-01_c.png', 1),
(4, 'politic-02_a.png', 2),
(5, 'politic-02_b.png', 2),
(6, 'politic-02_c.png', 2),
(7, 'politic-03_a.png', 3),
(8, 'politic-03_b.png', 3),
(9, 'politic-03_c.png', 3),
(10, 'politic-04_a.png', 4),
(11, 'politic-04_b.png', 4),
(12, 'politic-04_c.png', 4),
(13, 'sport-01_a.png', 5),
(14, 'sport-01_b.png', 5),
(15, 'sport-01_c.png', 5),
(16, 'sport-02_a.png', 6),
(17, 'sport-02_b.png', 6),
(18, 'sport-02_c.png', 6),
(19, 'sport-03_a.png', 7),
(20, 'sport-03_b.png', 7),
(21, 'sport-03_c.png', 7),
(22, 'health-01_a.png', 8),
(23, 'health-01_b.png', 8),
(24, 'health-01_c.png', 8),
(25, 'health-02_a.png', 9),
(26, 'health-02_b.png', 9),
(27, 'health-02_c.png', 9);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `firstname` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `email`, `firstname`, `name`, `password`, `role`, `username`) VALUES
(3, 'doejohn@gmail.com', 'john', 'doe', '$2a$10$PVWQUN1iFcrehXHikRlzR.fCAdzUdGRgNW3E2eYPYyH/rDYL/G1ki', 'admin', 'evengelius');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_jtpbwa5pnit13o8xxo64f7o18` (`title`),
  ADD KEY `FK4xgqesvq33owxvejmokt8r5h0` (`collection_id`);

--
-- Index pour la table `collections`
--
ALTER TABLE `collections`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ddet6fvs2nj65hg90ew34sgjy` (`name`);

--
-- Index pour la table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKk4ib6syde10dalk7r7xdl0m5p` (`article_id`);

--
-- Index pour la table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6b5b7yr23s8cegok85ayq9cgr` (`article_id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `articles`
--
ALTER TABLE `articles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `collections`
--
ALTER TABLE `collections`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `images`
--
ALTER TABLE `images`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `articles`
--
ALTER TABLE `articles`
  ADD CONSTRAINT `FK4xgqesvq33owxvejmokt8r5h0` FOREIGN KEY (`collection_id`) REFERENCES `collections` (`id`);

--
-- Contraintes pour la table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `FKk4ib6syde10dalk7r7xdl0m5p` FOREIGN KEY (`article_id`) REFERENCES `articles` (`id`);

--
-- Contraintes pour la table `images`
--
ALTER TABLE `images`
  ADD CONSTRAINT `FK6b5b7yr23s8cegok85ayq9cgr` FOREIGN KEY (`article_id`) REFERENCES `articles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
