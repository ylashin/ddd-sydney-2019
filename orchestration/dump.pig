loaded_file = LOAD '$input' AS (line:chararray);
filtered_data = FILTER loaded_file BY line IS NOT NULL;
partial_file = LIMIT filtered_data  $limit;
STORE partial_file INTO '$output';