-- 코드를 작성해주세요
SELECT 
    ID,
    CASE 
        WHEN pct_rank <= 0.25 THEN 'CRITICAL'
        WHEN pct_rank <= 0.50 THEN 'HIGH'
        WHEN pct_rank <= 0.75 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM (
    SELECT 
        ID,
        PERCENT_RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) AS pct_rank
    FROM ECOLI_DATA
) ranked
ORDER BY ID;