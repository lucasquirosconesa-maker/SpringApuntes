-- 1. Entrenadores
INSERT INTO trainers (id, name, hometown) VALUES
(1, 'Ash Ketchum', 'Pueblo Paleta'),
(2, 'Misty', 'Ciudad Celeste'),
(3, 'Brock', 'Ciudad Plateada');

-- 2. Habilidades
INSERT INTO abilities (id, name, description) VALUES
(1, 'Electricidad Estática', 'Puede paralizar al atacante si recibe un golpe de contacto.'),
(2, 'Mar Llamas', 'Potencia los movimientos de tipo Fuego cuando le quedan pocos PS.'),
(3, 'Poder Solar', 'Aumenta el Ataque Especial con sol, pero resta PS en cada turno.'),
(4, 'Cura Natural', 'Cura los problemas de estado al cambiar de Pokémon.'),
(5, 'Presión', 'Hace que el rival gaste el doble de PP al usar movimientos.');

-- 3. Pokémon (incluye URLs reales de sprites para probar el frontend)
INSERT INTO pokemon (id, name, imagen_url, `type`, trainer_id, `description`) VALUES
(1, 'Pikachu', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png', 'Eléctrico', 1, 'Almacena electricidad en las bolsas de sus mejillas.'),
(2, 'Charizard', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png', 'Fuego/Volador', 1, 'Escupe un fuego tan caliente que funde las rocas.'),
(3, 'Starmie', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/121.png', 'Agua/Psíquico', 2, 'Su núcleo central brilla con los siete colores del arcoíris.'),
(4, 'Mewtwo', 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/150.png', 'Psíquico', NULL, 'Pokémon salvaje creado por recombinación genética.');

-- 4. Estadísticas (relación 1 a 1 con Pokémon)
INSERT INTO pokemon_stats (id, hp, attack, defense, speed, height, weight, pokemon_id) VALUES
(1, 35, 55, 40, 90, 0.4, 6.0, 1),
(2, 78, 84, 78, 100, 1.7, 90.5, 2),
(3, 60, 75, 85, 115, 1.1, 80.0, 3),
(4, 106, 110, 90, 130, 2.0, 122.0, 4);

-- 5. Tabla intermedia Pokémon - Habilidades
INSERT INTO pokemon_abilities (pokemon_id, ability_id) VALUES
(1, 1), -- Pikachu -> Electricidad Estática
(2, 2), -- Charizard -> Mar Llamas
(2, 3), -- Charizard -> Poder Solar (prueba relación múltiple)
(3, 4), -- Starmie -> Cura Natural
(4, 5); -- Mewtwo -> Presión
