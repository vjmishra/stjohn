INSERT INTO CLW_BUDGET_DETAIL  (BUDGET_DETAIL_ID,BUDGET_ID,PERIOD,AMOUNT,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY)

Select CLW_BUDGET_DETAIL_SEQ.nextval,BUDGET_ID,PERIOD,AMOUNT,ADD_DATE,ADD_BY,MOD_DATE,MOD_BY from

(SELECT BUDGET_ID,1 AS PERIOD,AMOUNT1 AS AMOUNT,sysdate AS ADD_DATE,'achickin' AS ADD_BY,sysdate AS MOD_DATE,'achickin' AS MOD_BY from CLW_BUDGET
union
SELECT BUDGET_ID,2 AS PERIOD,AMOUNT2 AS AMOUNT,sysdate AS ADD_DATE,'achickin' AS ADD_BY,sysdate AS MOD_DATE,'achickin' AS MOD_BY from CLW_BUDGET
union
SELECT BUDGET_ID,3 AS PERIOD,AMOUNT3 AS AMOUNT,sysdate AS ADD_DATE,'achickin' AS ADD_BY,sysdate AS MOD_DATE,'achickin' AS MOD_BY from CLW_BUDGET
union
SELECT BUDGET_ID,4 AS PERIOD,AMOUNT4 AS AMOUNT,sysdate AS ADD_DATE,'achickin' AS ADD_BY,sysdate AS MOD_DATE,'achickin' AS MOD_BY from CLW_BUDGET
union
SELECT BUDGET_ID,5 AS PERIOD,AMOUNT5 AS AMOUNT,sysdate AS ADD_DATE,'achickin' AS ADD_BY,sysdate AS MOD_DATE,'achickin' AS MOD_BY from CLW_BUDGET
union
SELECT BUDGET_ID,6 AS PERIOD,AMOUNT6 AS AMOUNT,sysdate AS ADD_DATE,'achickin' AS ADD_BY,sysdate AS MOD_DATE,'achickin' AS MOD_BY from CLW_BUDGET
union
SELECT BUDGET_ID,7 AS PERIOD,AMOUNT7 AS AMOUNT,sysdate AS ADD_DATE,'achickin' AS ADD_BY,sysdate AS MOD_DATE,'achickin' AS MOD_BY from CLW_BUDGET
union
SELECT BUDGET_ID,8 AS PERIOD,AMOUNT8 AS AMOUNT,sysdate AS ADD_DATE,'achickin' AS ADD_BY,sysdate AS MOD_DATE,'achickin' AS MOD_BY from CLW_BUDGET
union
SELECT BUDGET_ID,9 AS PERIOD,AMOUNT9 AS AMOUNT,sysdate AS ADD_DATE,'achickin' AS ADD_BY,sysdate AS MOD_DATE,'achickin' AS MOD_BY from CLW_BUDGET
union
SELECT BUDGET_ID,10 AS PERIOD,AMOUNT10 AS AMOUNT,sysdate AS ADD_DATE,'achickin' AS ADD_BY,sysdate AS MOD_DATE,'achickin' AS MOD_BY from CLW_BUDGET
union
SELECT BUDGET_ID,11 AS PERIOD,AMOUNT11 AS AMOUNT,sysdate AS ADD_DATE,'achickin' AS ADD_BY,sysdate AS MOD_DATE,'achickin' AS MOD_BY from CLW_BUDGET
union
SELECT BUDGET_ID,12 AS PERIOD,AMOUNT12 AS AMOUNT,sysdate AS ADD_DATE,'achickin' AS ADD_BY,sysdate AS MOD_DATE,'achickin' AS MOD_BY from CLW_BUDGET
union
SELECT BUDGET_ID,13 AS PERIOD,AMOUNT13 AS AMOUNT,sysdate AS ADD_DATE,'achickin' AS ADD_BY,sysdate AS MOD_DATE,'achickin' AS MOD_BY from CLW_BUDGET);
