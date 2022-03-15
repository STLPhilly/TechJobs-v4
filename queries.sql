-- Part 1: Search for all jobs.
SELECT * FROM ${APP_DB_NAME}.job;
-- Part 2: Search for all employer with location: "St.Louis".
SELECT location
FROM employer
WHERE (location = "St. Louis");
-- Part 3: Delete job table.
SET foreign_key_checks = 0;
DROP TABLE job;
SET foreign_key_checks = 1;
-- Part 4: write a query to return a list all skills
-- that are attached to jobs in alphabetical order. If a skill does not have a job listed,
-- it should not be included in the results of this query.
SELECT *
FROM ${APP_DB_NAME}.skill
INNER JOIN job
WHERE job IS NOT NULL;

