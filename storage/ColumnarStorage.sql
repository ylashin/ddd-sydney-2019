----------------------------------- Classic Rowstore ---------------------------------------------------------

DROP TABLE IF EXISTS dbo.MyOrderLines
SELECT * INTO dbo.MyOrderLines FROM Sales.OrderLines
GO

ALTER TABLE dbo.MyOrderLines ADD CONSTRAINT PK_MyOrderLines PRIMARY KEY CLUSTERED (OrderLineID) 
GO

sp_spaceused 'dbo.MyOrderLines'
GO

SELECT SUM(Quantity * UnitPrice)  FROM dbo.MyOrderLines
GO

----------------------------------- Columnstore ---------------------------------------------------------

DROP TABLE IF EXISTS dbo.MyOrderLinesColumnar
SELECT * INTO dbo.MyOrderLinesColumnar FROM Sales.OrderLines
GO

CREATE CLUSTERED COLUMNSTORE INDEX ClusteredColumnStoreIndex_MyOrderLinesColumnar ON dbo.MyOrderLinesColumnar ON [USERDATA]
GO

sp_spaceused 'dbo.MyOrderLinesColumnar'
GO

SELECT SUM(Quantity * UnitPrice)  FROM dbo.MyOrderLinesColumnar
GO

