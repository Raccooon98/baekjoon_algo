-- 코드를 작성해주세요
SELECT count(*) AS COUNT
FROM ECOLI_DATA
where (GENOTYPE&2)=0
AND ((GENOTYPE & 1) > 0 OR (GENOTYPE & 4) > 0);